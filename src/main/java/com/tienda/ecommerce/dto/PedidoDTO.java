package com.tienda.ecommerce.dto;
import lombok.Data;
import java.util.List;
@Data
public class PedidoDTO {
    private Integer id;
    private String fecha;
    private List<ArticuloPedidoDTO> articulos;
}