package com.prasant.resturantManagementServiceAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adminAuthenticationTokens")
public class AdminAuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String token;
    private LocalDateTime generatedDate;
    @OneToOne
    private Admin admin;

    public AdminAuthenticationToken(Admin admin){
        this.token = UUID.randomUUID().toString();
        this.generatedDate = LocalDateTime.now();
        this.admin = admin;
    }
}
