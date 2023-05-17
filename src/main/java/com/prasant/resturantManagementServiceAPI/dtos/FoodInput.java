package com.prasant.resturantManagementServiceAPI.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodInput {
    @NotEmpty
    private String title;
    private String description;
    @Min(1)
    private Double price;
    private String dummyImage;
}
