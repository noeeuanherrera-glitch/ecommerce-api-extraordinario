package com.tienda.ecommerce.controller;

import com.tienda.ecommerce.entity.Marca;
import com.tienda.ecommerce.service.MarcaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
@Tag(name = "Marcas", description = "Endpoints para la gestión de marcas")
public class MarcaController {

    private final MarcaService service;

    @GetMapping
    @Operation(summary = "Obtener todas las marcas")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public ResponseEntity<List<Marca>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener marca por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Marca encontrada"),
            @ApiResponse(responseCode = "404", description = "Marca no encontrada")
    })
    public ResponseEntity<Marca> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nueva marca")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Marca creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Petición inválida")
    })
    public ResponseEntity<Marca> create(
            @RequestBody(
                    description = "Estructura JSON para crear una marca",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = Marca.class),
                            examples = @ExampleObject(
                                    value = "{\"nombre\": \"Nike\"}"
                            )
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody Marca marca
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(marca));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar marca por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Marca eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Marca no encontrada")
    })
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}