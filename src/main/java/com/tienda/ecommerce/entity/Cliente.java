package com.tienda.ecommerce.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; private String nombre; private String email;
}