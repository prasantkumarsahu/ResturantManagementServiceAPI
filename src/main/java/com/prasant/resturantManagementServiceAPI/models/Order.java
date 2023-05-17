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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private LocalDateTime dateAndTime;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    private Food food;
    @ManyToOne
    private User user;
    @ManyToOne
    private Admin admin;

    public Order(Integer quantity, Food food, User user) {
        this.quantity = quantity;
        this.food = food;
        this.user = user;
        this.dateAndTime = LocalDateTime.now();
        this.status = OrderStatus.CREATED;
    }

    public Order(Integer quantity, Food food, Admin admin) {
        this.quantity = quantity;
        this.food = food;
        this.admin = admin;
        this.dateAndTime = LocalDateTime.now();
        this.status = OrderStatus.CREATED;
    }
}
