package es.safareyes.swapcloset.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.sql.Date;
import java.sql.Timestamp;

public record UsuarioRequestDTO(
        @NotBlank(message = "El nombre es Obligatorio")
        String nombre,

        @NotBlank(message= "La contraseña es Obligatoria")
        @Size(min = 6, message = "La contraseña tiene que ser almenos de 6 caracteres")
        String contraseña,

        @NotBlank(message = "Se necesita autorizacion")
        String autorizacion,

        @NotBlank(message = "Se necesita una fecha de registro")
        Timestamp fechaRegistro,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "Formato incorrecto")
        String email,

        @NotBlank(message = "La fecha de nacimiento es obligatoria")
        Date fechaNacimiento

) {}
