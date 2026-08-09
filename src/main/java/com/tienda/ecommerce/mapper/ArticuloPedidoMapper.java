package com.tienda.ecommerce.mapper;
import com.tienda.ecommerce.entity.ArticuloPedido;
import com.tienda.ecommerce.dto.ArticuloPedidoDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface ArticuloPedidoMapper {
    ArticuloPedidoDTO toDTO(ArticuloPedido entity);
    ArticuloPedido toEntity(ArticuloPedidoDTO dto);
}