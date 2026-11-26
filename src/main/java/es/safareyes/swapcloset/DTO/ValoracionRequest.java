package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.NotNull;

public record ValoracionRequest(
        @NotNull Integer puntuacion,
        String comentario
) {}