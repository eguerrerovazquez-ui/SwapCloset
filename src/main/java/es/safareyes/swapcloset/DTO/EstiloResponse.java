package es.safareyes.swapcloset.DTO;

import es.safareyes.swapcloset.modelos.TipoEstilo;

public record EstiloResponse(
        Integer id,
        TipoEstilo tipo
) {}