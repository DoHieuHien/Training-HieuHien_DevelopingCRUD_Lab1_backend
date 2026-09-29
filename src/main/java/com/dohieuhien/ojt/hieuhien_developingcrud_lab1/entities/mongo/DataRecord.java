package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mongo;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "business_data")
public class DataRecord {

    @Id
    private String id;
    private String title;
    private Object payload;
}
