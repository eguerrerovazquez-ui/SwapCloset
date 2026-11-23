package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public record UsuarioRequest(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String contrasena,
        @NotNull @Past LocalDate fechaNacimiento
) {}