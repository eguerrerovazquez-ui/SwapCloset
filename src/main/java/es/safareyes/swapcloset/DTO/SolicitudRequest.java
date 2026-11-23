package es.safareyes.swapcloset.DTO;

import es.safareyes.swapcloset.modelos.TipoSolicitud;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record SolicitudRequest(
        @NotNull TipoSolicitud tipo,
        @NotNull @Positive Integer idPrendaSolicitada,
        @Positive Integer idPrendaOfrecida,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin
) {}