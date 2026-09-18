package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class DataInformation {
    private Long id;
    private String DataId;
    private String DataDetails;
    private String DataDate;
}
