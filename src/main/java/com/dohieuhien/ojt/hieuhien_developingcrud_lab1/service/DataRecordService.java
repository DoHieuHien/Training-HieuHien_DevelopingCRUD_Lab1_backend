package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mongo.DataRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface DataRecordService {
    Page<DataRecord> list(Pageable pageable);
    DataRecord getById(String id);
    int importCsv(MultipartFile file) throws IOException;
    byte[] exportCsv();
}
