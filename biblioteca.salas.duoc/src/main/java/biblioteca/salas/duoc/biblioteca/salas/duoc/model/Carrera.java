package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carrera")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo de Carrera", name = "Carrera")
public class Carrera {
    @Id
    @Schema(description = "Código de la carrera", example = "INF-2026")
    private String codigo;
    @Schema(description = "Código nombre de la carrera", example = "Ingeniería en Informática")
    private String nombre;

}
