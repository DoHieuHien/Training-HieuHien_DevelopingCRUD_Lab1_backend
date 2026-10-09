package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mongo.DataRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRecordRepo extends MongoRepository<DataRecord, String> {

}
