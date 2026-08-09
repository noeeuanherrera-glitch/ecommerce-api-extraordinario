package com.tienda.ecommerce.dto;
import lombok.Data;
@Data
public class ArticuloPedidoDTO {
    private Integer id;
    private Integer cantidad;
    private String nombreProducto;
}