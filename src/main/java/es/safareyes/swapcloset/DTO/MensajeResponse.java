package es.safareyes.swapcloset.DTO;

import java.time.LocalDateTime;

public record MensajeResponse(
        Integer id,
        Integer idPerfilEmisor,
        Integer idPerfilReceptor,
        LocalDateTime fechaEnvio,
        String contenido
) {}