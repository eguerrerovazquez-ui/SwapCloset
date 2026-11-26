package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record NotificacionesRequest(
        @NotNull @Positive Integer idPerfil,
        @NotBlank String tipo,
        @NotBlank String texto
) {}