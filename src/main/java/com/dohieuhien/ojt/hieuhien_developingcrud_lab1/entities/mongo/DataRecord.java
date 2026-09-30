package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mongo;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "business_data")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataRecord {

    @Id
    private String id;
    private String title;
    private Object payload;
}
