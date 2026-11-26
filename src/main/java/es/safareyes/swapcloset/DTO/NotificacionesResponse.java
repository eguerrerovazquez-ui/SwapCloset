package es.safareyes.swapcloset.DTO;

import java.time.LocalDateTime;

public record NotificacionesResponse(
        Integer id,
        Integer idPerfil,
        String tipo,
        String texto,
        LocalDateTime fecha,
        LocalDateTime fechaLeida
) {}