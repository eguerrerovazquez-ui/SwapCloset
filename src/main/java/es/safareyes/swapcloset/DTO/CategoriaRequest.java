package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(
        @NotBlank String nombre
) {}