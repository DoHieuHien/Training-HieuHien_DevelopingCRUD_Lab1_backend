package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.DataInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataInforRepo extends JpaRepository<DataInfor, Long> {
}
