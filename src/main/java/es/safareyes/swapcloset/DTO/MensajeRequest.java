package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.NotBlank;

public record MensajeRequest(@NotBlank String contenido) {}