package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.impl;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.DataInfor;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.DataInforRepo;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataInforService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataInforServiceImpl implements DataInforService {

    @Autowired
    private DataInforRepo dataInforRepo;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");

    @Override
    public Page<DataInfor> listPage(Pageable pageable) {
        return dataInforRepo.findAll(pageable);
    }

    @Override
    public DataInfor getById(Long id) {
        return dataInforRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Data not found:" + id));
    }

    @Override
    public int importData(MultipartFile file) throws IOException {

        List<DataInfor> toSave = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        file.getInputStream(),
                        StandardCharsets.UTF_8))) {

            // Bỏ dòng header
            String header = reader.readLine();

            System.out.println("HEADER: " + header);

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println("LINE: " + line);

                if (line.isBlank()) {
                    continue;
                }

                String[] cols = line.split(",", -1);

                System.out.println("COLUMN COUNT: " + cols.length);

                if (cols.length < 3) {
                    System.out.println("SKIP: Không đủ 3 cột");
                    continue;
                }

                DataInfor data = DataInfor.builder()
                        .idData(cols[0].trim())
                        .dataDetails(cols[1].trim())
                        .dataDate(
                                LocalDateTime.parse(
                                        cols[2].trim(),
                                        DATE_TIME_FORMATTER
                                )
                        )
                        .build();

                toSave.add(data);
            }
        }

        dataInforRepo.saveAll(toSave);
        return toSave.size();
    }


    @Override
    public byte[] exportData() {

        StringBuilder stringBuilder =
                new StringBuilder("idData,dataDetails,dataDate\n");

        for (DataInfor x : dataInforRepo.findAll()) {

            stringBuilder
                    .append(x.getIdData()).append(",")
                    .append(x.getDataDetails()).append(",")
                    .append(x.getDataDate().format(DATE_TIME_FORMATTER))
                    .append("\n");
        }

        return stringBuilder
                .toString()
                .getBytes(StandardCharsets.UTF_8);
    }
}
