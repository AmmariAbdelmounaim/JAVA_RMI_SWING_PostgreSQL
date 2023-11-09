package com.example.RMI;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // generate getters and setters
@Builder            // design patter builder
@NoArgsConstructor  // constructor with no arguments
@AllArgsConstructor // constructor with all arguments
@Entity             // make this user entity
@Table(name="account")
public class Account {
    @Id
    private String id;
    private double balance;


}
