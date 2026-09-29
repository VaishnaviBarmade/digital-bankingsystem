package com.bank.bankapplication.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true,nullable=false)
    private String email;

    @Column(unique=true,nullable=false)
    private String mobileNumber;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String role;



}
