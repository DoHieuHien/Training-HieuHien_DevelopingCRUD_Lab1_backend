package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank String username,
    @NotBlank String password
) {}

