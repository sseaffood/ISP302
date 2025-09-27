package com.g5.techdevices.techstore.entity.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", length = 200)
    private String name;

    @Column(name = "user_email", nullable = false, length = 255)
    private String email;

    @Column(name = "user_pass", nullable = false, length = 255)
    private String password;

    @Column(name = "user_gender")
    private Boolean gender;

    @Column(name = "user_phoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "user_role", length = 20)
    private String role;

    @Column(name = "isActive")
    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<Bill> bills;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;
}
