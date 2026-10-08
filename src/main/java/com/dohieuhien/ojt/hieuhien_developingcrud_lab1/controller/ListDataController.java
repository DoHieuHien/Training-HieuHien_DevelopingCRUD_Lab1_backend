package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.controller;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.dto.LoginRespond;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.DataInfor;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataInforService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hien/data")
@RequiredArgsConstructor
public class ListDataController {

    private final DataInforService dataInforService;

    @GetMapping
    public Page<DataInfor> infors(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        return dataInforService.listPage(PageRequest.of(page, size, Sort.by("dataDate").descending()));
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> export(){
        byte[] bytes = dataInforService.exportData();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data-export.detail")
                .contentType(MediaType.parseMediaType("text/detail"))
                .body(bytes);
    }
}
