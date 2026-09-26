package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table (name = "data_infor")

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class DataInfor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "id_data", nullable = false, unique = true, length = 20)
    private String idData;

    @Column (name = "data_details", nullable = false, length = 50)
    private String dataDetails;

    @Column (name = "data_date", nullable = false)
    private LocalDateTime dataDate;
}
