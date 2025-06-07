package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.SalaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
@Tag(name = "Salas", description = "Operaciones relacionadas con las salas")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @GetMapping
    @Operation(summary = "Obtener todas las salas", description = "Obtiene una lista de todas las salas")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class),
                examples = @ExampleObject(
                    value = "[{\"codigo\": 101, \"nombre\": \"Sala de Estudio 1\"}]")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Sala no encontrada"
        )
    })
    public List<Sala> getAllSalas() {
        return salaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener sala por id", description = "Obtiene una sala según el id")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": 101, \"nombre\": \"Sala de Estudio 1\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Sala no encontrada"
        )
    })
    public Sala getSalaById(
        @Parameter(description = "ID de la sala", example = "101")
        @PathVariable Integer id
    ) {
        return salaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva sala", description = "Agrega una sala")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": 101, \"nombre\": \"Sala de Estudio 1\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Sala no encontrada"
        )
    })
    public Sala createSala(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la sala a crear",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Sala.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": 101, \"nombre\": \"Sala de Estudio 1\"}")
            )
        )
        @RequestBody Sala sala
    ) {
        return salaService.save(sala);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una sala", description = "Actualiza una sala")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": 101, \"nombre\": \"Sala de Estudio 1\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Sala no encontrada"
        )
    })
    public Sala updateSala(
        @Parameter(description = "ID de la sala a actualizar", example = "101")
        @PathVariable Integer id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la sala actualizados",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Sala.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": 101, \"nombre\": \"Sala de Estudio 1\"}")
            )
        )
        @RequestBody Sala sala
    ) {
        sala.setCodigo(id);
        return salaService.save(sala);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una sala", description = "Elimina una sala")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Sala.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": 101, \"nombre\": \"Sala de Estudio 1\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Sala no encontrada"
        )
    })
    public void deleteSala(
        @Parameter(description = "ID de la sala a eliminar", example = "101")
        @PathVariable Integer id
    ) {
        salaService.deleteById(id);
    }
}
