package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.controller;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataInforService;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;



@RestController
@RequestMapping("/hien/data")
@RequiredArgsConstructor
public class ImportDataController {

    private final DataRecordService dataRecordService;

    @PostMapping("/import")
    public ResponseEntity<Map<String, Object>> importData(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "File rỗng"));
        }
        int count = dataRecordService.importCsv(file);
        return ResponseEntity.ok(Map.of("message", "Import thành công", "count", count));
    }
}
