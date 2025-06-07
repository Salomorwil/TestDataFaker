package biblioteca.salas.duoc.biblioteca.salas.duoc.controller;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Reserva;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.ReservaService;
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
@RequestMapping("/api/reservas")
@Tag(name = "Reservas", description = "Operaciones relacionadas con las reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    @Operation(summary = "Obtener todas las reservas", description = "Obtiene una lista de todas las reservas")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class),
                examples = @ExampleObject(
                    value = "[{\"id\": 1, \"fechaSolicitada\": \"2025-06-06\"}]")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Reserva no encontrada"
        )
    })
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener reserva por id", description = "Obtiene una reserva según el id")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"fechaSolicitada\": \"2025-06-06\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Reserva no encontrada"
        )
    })
    public Reserva getReservaById(
        @Parameter(description = "ID de la reserva", example = "1")
        @PathVariable Integer id
    ) {
        return reservaService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva reserva", description = "Agrega una reserva")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"fechaSolicitada\": \"2025-06-06\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Reserva no encontrada"
        )
    })
    public Reserva createReserva(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la reserva a crear",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Reserva.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"fechaSolicitada\": \"2025-06-06\"}")
            )
        )
        @RequestBody Reserva reserva
    ) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una reserva", description = "Actualiza una reserva")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"fechaSolicitada\": \"2025-06-06\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Reserva no encontrada"
        )
    })
    public Reserva updateReserva(
        @Parameter(description = "ID de la reserva a actualizar", example = "1")
        @PathVariable Integer id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la reserva actualizados",
            required = true,
            content = @Content(
                schema = @Schema(implementation = Reserva.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"fechaSolicitada\": \"2025-06-06\"}")
            )
        )
        @RequestBody Reserva reserva
    ) {
        reserva.setId(id);
        return reservaService.save(reserva);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una reserva", description = "Elimina una reserva")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operación exitosa",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Reserva.class),
                examples = @ExampleObject(
                    value = "{\"id\": 1, \"fechaSolicitada\": \"2025-06-06\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Reserva no encontrada"
        )
    })
    public void deleteReserva(
        @Parameter(description = "ID de la reserva a eliminar", example = "1")
        @PathVariable Integer id
    ) {
        reservaService.deleteById(id);
    }
}