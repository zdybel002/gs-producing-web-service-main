package com.example.producingwebservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table(name = "courses", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "course_fee", nullable = false, precision = 10, scale = 2)
    private BigDecimal courseFee;

    @Override
    public String toString() {
        return "Cours{" +
                "courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}