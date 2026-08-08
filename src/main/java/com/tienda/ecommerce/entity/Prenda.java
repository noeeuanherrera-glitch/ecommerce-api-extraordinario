package com.tienda.ecommerce.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Prenda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; private String nombre; private Double precio;
}