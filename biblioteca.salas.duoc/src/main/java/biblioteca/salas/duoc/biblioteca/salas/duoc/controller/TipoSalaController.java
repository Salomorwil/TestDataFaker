package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.TipoSalaService;
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
@RequestMapping("/api/tipo-salas")
@Tag(name = "TipoSalas", description = "Operaciones relacionadas con los tipos de sala")
public class TipoSalaController {
    @Autowired
    private TipoSalaService tipoSalaService;

    @GetMapping
    @Operation(summary = "Obtener todos los tipos de sala", description = "Obtiene una lista de todos los tipos de sala")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class),
                examples = @ExampleObject(
                    value = "[{\"idTipo\": 1, \"nombre\": \"Sala de Computación\"}]")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "TipoSala no encontrado"
        )
    })
    public List<TipoSala> getAllTipoSalas() {
        return tipoSalaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de sala por id", description = "Obtiene un tipo de sala según el id")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class),
                examples = @ExampleObject(
                    value = "{\"idTipo\": 1, \"nombre\": \"Sala de Computación\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "TipoSala no encontrado"
        )
    })
    public TipoSala getTipoSalaById(
        @Parameter(description = "ID del tipo de sala", example = "1")
        @PathVariable Integer id
    ) {
        return tipoSalaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo tipo de sala", description = "Agrega un tipo de sala")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class),
                examples = @ExampleObject(
                    value = "{\"idTipo\": 1, \"nombre\": \"Sala de Computación\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "TipoSala no encontrado"
        )
    })
    public TipoSala createTipoSala(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del tipo de sala a crear",
            required = true,
            content = @Content(
                schema = @Schema(implementation = TipoSala.class),
                examples = @ExampleObject(
                    value = "{\"idTipo\": 1, \"nombre\": \"Sala de Computación\"}")
            )
        )
        @RequestBody TipoSala tipoSala
    ) {
        return tipoSalaService.save(tipoSala);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un tipo de sala", description = "Actualiza un tipo de sala")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class),
                examples = @ExampleObject(
                    value = "{\"idTipo\": 1, \"nombre\": \"Sala de Computación\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "TipoSala no encontrado"
        )
    })
    public TipoSala updateTipoSala(
        @Parameter(description = "ID del tipo de sala a actualizar", example = "1")
        @PathVariable Integer id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del tipo de sala actualizados",
            required = true,
            content = @Content(
                schema = @Schema(implementation = TipoSala.class),
                examples = @ExampleObject(
                    value = "{\"idTipo\": 1, \"nombre\": \"Sala de Computación\"}")
            )
        )
        @RequestBody TipoSala tipoSala
    ) {
        tipoSala.setIdTipo(id);
        return tipoSalaService.save(tipoSala);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un tipo de sala", description = "Elimina un tipo de sala")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = TipoSala.class),
                examples = @ExampleObject(
                    value = "{\"idTipo\": 1, \"nombre\": \"Sala de Computación\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "TipoSala no encontrado"
        )
    })
    public void deleteTipoSala(
        @Parameter(description = "ID del tipo de sala a eliminar", example = "1")
        @PathVariable Integer id
    ) {
        tipoSalaService.deleteById(id);
    }
}
