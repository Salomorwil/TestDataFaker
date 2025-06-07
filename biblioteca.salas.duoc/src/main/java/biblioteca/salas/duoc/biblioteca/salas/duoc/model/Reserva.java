package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reserva")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo de Reserva", name = "Reserva")
public class Reserva {
    @Id
    @Schema(description = "ID de la reserva", example = "1")
    private Integer id;
    @Schema(description = "Fecha solicitada para la reserva", example = "2025-06-06")
    private Date fechaSolicitada;
    @Schema(description = "Hora solicitada para la reserva", example = "10:00:00")
    private Date horaSolicitada;
    @Schema(description = "Hora de cierre de la reserva", example = "12:00:00")
    private Date horaCierre;
    @Schema(description = "Estado de la reserva", example = "1")
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    @Schema(description = "Estudiante asociado a la reserva")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "codigo_sala", nullable = false)
    @Schema(description = "Sala asociada a la reserva")
    private Sala sala;

    // Getters and Setters
}