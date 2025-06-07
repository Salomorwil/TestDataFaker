package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_sala")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo de TipoSala", name = "TipoSala")
public class TipoSala {
    @Id
    @Schema(description = "ID del tipo de sala", example = "1")
    private Integer idTipo;
    @Schema(description = "Nombre del tipo de sala", example = "Sala de Computación")
    private String nombre;

    // Getters and Setters
}