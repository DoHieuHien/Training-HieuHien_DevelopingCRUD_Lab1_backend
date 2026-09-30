package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.DataInfor;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.DataInforRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

public interface DataInforService {
    Page<DataInfor> listPage(Pageable pageable);
    DataInfor getById(Long id);
    int importData(MultipartFile file) throws IOException;
    byte[] exportData();
}
