package com.example.provideservice.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private Double salary;
}
