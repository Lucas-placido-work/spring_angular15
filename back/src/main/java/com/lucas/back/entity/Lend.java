package com.lucas.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Tool tool;

    @ManyToOne
    private Employee employee;

    private LocalDate dateLend = LocalDate.now();
    private LocalDate dateReturn;
}
