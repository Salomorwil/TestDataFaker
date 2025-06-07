package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
@Tag(name = "Carreras", description = "Operaciones relacionadas con las carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    @Operation(summary =  "Obtener todas las carreras", description = "Obtiene una lista de todas las carreras")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class),
                examples = @ExampleObject(
                    value = "[{\"codigo\": \"INF-2026\", \"nombre\": \"Ingeniería en Informática\"}]"
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Carrera no encontrada"
        )
    })
    public List<Carrera> getAllCarreras() {
        return carreraService.findAll();
    }

    @GetMapping("/{codigo}")
    @Operation(summary =  "Obtener carrera por codigo", description = "Obtiene una carrera según el codigo")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": \"INF-2026\", \"nombre\": \"Ingeniería en Informática\"}"
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Carrera no encontrada"
        )
    })
    public Carrera getCarreraByCodigo(
        @Parameter(description = "Código de la carrera", example = "INF-2026")
        @PathVariable String codigo
    ) {
        return carreraService.findByCodigo(codigo);
    }

    @PostMapping
    @Operation(summary =  "Crear una nueva carrera", description = "Agrega una carrera")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": \"INF-2026\", \"nombre\": \"Ingeniería en Informática\"}"
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Carrera no encontrada"
        )
    })
    public Carrera createCarrera(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la carrera a crear",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Carrera.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": \"INF-2026\", \"nombre\": \"Ingeniería en Informática\"}"
                )
            )
        )
        @RequestBody Carrera carrera
    ) {
        return carreraService.save(carrera);
    }

    @PutMapping("/{codigo}")
    @Operation(summary =  "Actualizar una carrera", description = "Actualiza una carrera")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": \"INF-2026\", \"nombre\": \"Ingeniería en Informática\"}"
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Carrera no encontrada"
        )
    })
    public Carrera updateCarrera(
        @Parameter(description = "Código de la carrera a actualizar", example = "INF-2026")
        @PathVariable String codigo,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la carrera actualizada",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Carrera.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": \"INF-2026\", \"nombre\": \"Ingeniería en Informática\"}"
                )
            )
        )
        @RequestBody Carrera carrera
    ) {
        carrera.setCodigo(codigo);
        return carreraService.save(carrera);
    }

    @DeleteMapping("/{codigo}")
    @Operation(summary =  "Eliminar una carrera", description = "Eliminar una carrera")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Carrera.class),
                examples = @ExampleObject(
                    value = "{\"codigo\": \"INF-2026\", \"nombre\": \"Ingeniería en Informática\"}"
                )
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Carrera no encontrada"
        )
    })
    public void deleteCarrera(
        @Parameter(description = "Código de la carrera a eliminar", example = "INF-2026")
        @PathVariable String codigo
    ) {
        carreraService.deleteByCodigo(codigo);
    }
}
