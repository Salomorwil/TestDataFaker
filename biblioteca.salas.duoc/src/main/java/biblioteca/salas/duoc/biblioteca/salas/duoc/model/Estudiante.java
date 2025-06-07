package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiante")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo de Estudiante", name = "Estudiante")
public class Estudiante {
    @Id
    @Schema(description = "ID del estudiante", example = "1")
    private Integer id;
    @Schema(description = "RUN del estudiante", example = "12345678-9")
    private String run;
    @Schema(description = "Nombres del estudiante", example = "Juan Pérez")
    private String nombres;
    @Schema(description = "Correo del estudiante", example = "juan.perez@duocuc.cl")
    private String correo;
    @Schema(description = "Jornada del estudiante", example = "D")
    private char jornada;
    @Schema(description = "Teléfono del estudiante", example = "987654321")
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "codigo_carrera", nullable = false)
    @Schema(description = "Carrera asociada al estudiante")
    private Carrera carrera;

    // Getters and Setters
}