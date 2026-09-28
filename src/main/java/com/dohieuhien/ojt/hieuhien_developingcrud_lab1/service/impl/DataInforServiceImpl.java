package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.impl;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.DataInforRepo;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.DataInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataInforServiceImpl implements DataInforService {

    @Autowired
    private DataInforRepo dataInforRepo;
}
