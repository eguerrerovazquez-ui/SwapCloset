package es.safareyes.swapcloset.dto;

import java.sql.Date;
import java.sql.Timestamp;

public record UsuarioResponseDTO(

        String nombre,
        String contraseña,
        String Autrorizacion,
        Timestamp fechaRegistro,
        String email,
        Date fechaNcimiento

) {}
