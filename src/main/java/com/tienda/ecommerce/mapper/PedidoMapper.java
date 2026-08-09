package com.tienda.ecommerce.mapper;
import com.tienda.ecommerce.entity.Pedido;
import com.tienda.ecommerce.dto.PedidoDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoDTO toDTO(Pedido entity);
    Pedido toEntity(PedidoDTO dto);
}