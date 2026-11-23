package es.safareyes.swapcloset.DTO;

import java.time.LocalDateTime;

public record ValoracionResponse(
        Integer id,
        Integer idSolicitud,
        Integer idPerfil,
        Integer puntuacion,
        String comentario,
        LocalDateTime fecha
) {}