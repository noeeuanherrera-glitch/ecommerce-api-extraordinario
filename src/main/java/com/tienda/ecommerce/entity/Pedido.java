package com.tienda.ecommerce.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fecha;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticuloPedido> articulos = new ArrayList<>();
    
    public void addArticulo(ArticuloPedido articulo) {
        articulos.add(articulo);
        articulo.setPedido(this);
    }
}