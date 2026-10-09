package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.impl;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mongo.DataRecord;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.DataRecordRepo;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataInforService;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataRecordService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DataRecordServiceImpl implements DataRecordService {

    private final DataRecordRepo recordRepo;

    @Override
    public Page<DataRecord> list(Pageable pageable) {
        return recordRepo.findAll(pageable);
    }

    @Override
    public DataRecord getById(String id) {
        return recordRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Data not found: " +id));
    }

    @Override
    public int importCsv(MultipartFile file) throws IOException {
        List<DataRecord> toSave = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            String headerLine = reader.readLine();
            if (headerLine == null || headerLine.isBlank()) return 0;

            String[] headers = headerLine.split(",", -1);
            for (int i = 0; i < headers.length; i++) headers[i] = headers[i].trim();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] cols = line.split(",", -1);

                Map<String, Object> payload = new LinkedHashMap<>();
                for (int i = 0; i < headers.length && i < cols.length; i++) {
                    payload.put(headers[i], cols[i].trim());
                }

                String title = cols.length > 0 ? cols[0].trim() : "N/A";

                toSave.add(DataRecord.builder()
                        .title(title)
                        .payload(payload)
                        .build());
            }
        }
        recordRepo.saveAll(toSave);
        return toSave.size();
    }

    @Override
    @SuppressWarnings("unchecked")
    public byte[] exportCsv() {
       List<DataRecord> all = recordRepo.findAll();
       if(all.isEmpty()){
           return "id,title\n".getBytes(StandardCharsets.UTF_8);
       }

        LinkedHashSet<String> columns = new LinkedHashSet<>();
       for(DataRecord X : all){
           if(X.getPayload() instanceof Map<?,?>map){
               map.keySet().forEach(k -> columns.add(String.valueOf(k)));
           }
       }

       StringBuilder sb = new StringBuilder("id,title," + String.join(",", columns +"\n"));
        for (DataRecord r : all) {
            sb.append(r.getId()).append(",").append(r.getTitle());
            Map<String, Object> payload = r.getPayload() instanceof Map
                    ? (Map<String, Object>) r.getPayload() : Map.of();
            for (String col : columns) {
                sb.append(",").append(payload.getOrDefault(col, ""));
            }
            sb.append("\n");
        }
        return sb.toString().getBytes(StandardCharsets.UTF_8);
    }
}
