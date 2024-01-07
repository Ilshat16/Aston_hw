package ru.aston.pizzeria.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("DK")
public class Drink extends Food{

    @Column(name = "value")
    private int value;
}