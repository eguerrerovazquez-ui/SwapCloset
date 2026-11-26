package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record FotoPrendaRequest(
        @NotBlank String url,
        @PositiveOrZero Integer orden
) {}