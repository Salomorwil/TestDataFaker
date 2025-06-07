package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Tag(name = "Estudiantes", description = "Operaciones relacionadas con los estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    @Operation(summary = "Obtener todos los estudiantes", description = "Obtiene una lista de todos los estudiantes")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class),
                examples = @ExampleObject(
                    value = "[{\"id\": 1, \"run\": \"12345678-9\", \"nombres\": \"Juan Perez\"}]")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Estudiante no encontrado"
        )
    })
    public List<Estudiante> getAllEstudiantes() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estudiante por id", description = "Obtiene un estudiante según el id")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"run\": \"12345678-9\", \"nombres\": \"Juan Perez\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Estudiante no encontrado"
        )
    })
    public Estudiante getEstudianteById(
        @Parameter(description = "ID del estudiante", example = "1")
        @PathVariable Integer id
    ) {
        return estudianteService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo estudiante", description = "Agrega un estudiante")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"run\": \"12345678-9\", \"nombres\": \"Juan Perez\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Estudiante no encontrado"
        )
    })
    public Estudiante createEstudiante(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del estudiante a crear",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Estudiante.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"run\": \"12345678-9\", \"nombres\": \"Juan Perez\"}")
            )
        )
        @RequestBody Estudiante estudiante
    ) {
        return estudianteService.save(estudiante);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un estudiante", description = "Actualiza un estudiante")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"run\": \"12345678-9\", \"nombres\": \"Juan Perez\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Estudiante no encontrado"
        )
    })
    public Estudiante updateEstudiante(
        @Parameter(description = "ID del estudiante a actualizar", example = "1")
        @PathVariable Integer id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del estudiante actualizados",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Estudiante.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"run\": \"12345678-9\", \"nombres\": \"Juan Perez\"}")
            )
        )
        @RequestBody Estudiante estudiante
    ) {
        estudiante.setId(id);
        return estudianteService.save(estudiante);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un estudiante", description = "Elimina un estudiante")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Estudiante.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"run\": \"12345678-9\", \"nombres\": \"Juan Perez\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Estudiante no encontrado"
        )
    })
    public void deleteEstudiante(
        @Parameter(description = "ID del estudiante a eliminar", example = "1")
        @PathVariable Integer id
    ) {
        estudianteService.deleteById(id);
    }
}
