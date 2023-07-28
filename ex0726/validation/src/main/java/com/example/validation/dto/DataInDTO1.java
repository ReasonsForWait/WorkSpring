package com.example.validation.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataInDTO1 {
    @Size(min = 3, max = 7)
    private String text3;
    @Size(min = 1, max = 5)
    private String text4;
}
