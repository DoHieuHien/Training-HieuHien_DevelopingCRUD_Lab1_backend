package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.DataInfor;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataInforRepo extends JpaRepository<DataInfor, Long> {
}
