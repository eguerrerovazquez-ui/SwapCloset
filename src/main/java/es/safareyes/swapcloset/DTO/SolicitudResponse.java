package es.safareyes.swapcloset.DTO;

import es.safareyes.swapcloset.modelos.TipoSolicitud;
import java.time.LocalDateTime;

public record SolicitudResponse(
        Integer id,
        Integer idPerfilSolicitante,
        Integer idPerfilDestinatario,
        Integer idPrendaSolicitada,
        Integer idPrendaOfrecida,
        TipoSolicitud tipo,
        String estado,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        LocalDateTime fechaCaducidad
) {}