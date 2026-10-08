package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.controller;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataInforService;
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

    private final DataInforService dataInforService;

    @PostMapping("/import")
    public ResponseEntity<Map<String, Object>> importData(@RequestParam("file")MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body(Map.of("message","Empty file"));
        }
        String name = file.getOriginalFilename();
        if (name == null || !name.toLowerCase().endsWith(".csv")) {
            return ResponseEntity.badRequest().body(Map.of("message", "File không hợp lệ, chỉ chấp nhận file .csv"));
        }
        int count = dataInforService.importData(file);
        return ResponseEntity.ok(Map.of("message", "Import Successfully"));
    }


}
