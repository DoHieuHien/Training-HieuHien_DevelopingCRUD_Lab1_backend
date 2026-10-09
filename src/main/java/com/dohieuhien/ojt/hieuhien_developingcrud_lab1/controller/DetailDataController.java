package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.controller;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mongo.DataRecord;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.DataInfor;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataInforService;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hien/data")
@RequiredArgsConstructor
public class DetailDataController {

    private final DataRecordService dataRecordService;

    @GetMapping("/{id}")
    public DataRecord detail(@PathVariable String id) {   // id giờ là String (Mongo ObjectId)
        return dataRecordService.getById(id);
    }
}
