package com.prasant.resturantManagementServiceAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String dummyImage;
    private LocalDateTime dateAndTime;

    public Food(String title, String description, Double price, String dummyImage) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.dummyImage = dummyImage;
        this.dateAndTime = LocalDateTime.now();
    }

    public Food(Long id) {
        this.id = id;
    }
}
