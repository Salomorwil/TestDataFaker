package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sala")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo de Sala", name = "Sala")
public class Sala {
    @Id
    @Schema(description = "Código de la sala", example = "101")
    private Integer codigo;
    @Schema(description = "Nombre de la sala", example = "Sala de Estudio 1")
    private String nombre;
    @Schema(description = "Capacidad de la sala", example = "20")
    private Integer capacidad;
    @Schema(description = "ID del instituto", example = "1")
    private Integer idInstituo;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    @Schema(description = "Tipo de sala asociada")
    private TipoSala tipoSala;

    // Getters and Setters
}