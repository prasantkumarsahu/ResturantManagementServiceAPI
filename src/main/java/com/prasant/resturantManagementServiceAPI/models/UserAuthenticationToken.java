package com.prasant.resturantManagementServiceAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userAuthenticationTokens")
public class UserAuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String token;
    private LocalDateTime generatedDate;
    @OneToOne
    @JoinColumn(nullable = false)
    private User user;

    public UserAuthenticationToken(User user){
        this.token = UUID.randomUUID().toString();
        this.generatedDate = LocalDateTime.now();
        this.user = user;
    }
}
