package com.g5.techdevices.techstore.entity.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "total", columnDefinition = "money", nullable = false)
    private BigDecimal total;

    @Column(name = "payment", nullable = false, length = 250)
    private String payment;

    @Column(name = "address", columnDefinition = "nvarchar(max)", nullable = false)
    private String address;

    private LocalDate date;

    @Column(length = 15, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "bill")
    private List<BillDetail> details;
}