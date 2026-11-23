package es.safareyes.swapcloset.DTO;

import es.safareyes.swapcloset.modelos.TipoEstilo;
import jakarta.validation.constraints.NotNull;

public record EstiloRequest(@NotNull TipoEstilo tipo) {}