package com.hieujavahound.carhub.entity;

import com.hieujavahound.carhub.enums.InsuranceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "insurance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InsuranceType insuranceType;

    @Column(nullable = false)
    private double coverageAmount;

    @Column(nullable = false)
    private double dailyRate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "insurances")
    List<Rental> rentals = new ArrayList<>();
}