package es.safareyes.swapcloset.DTO;

import java.math.BigDecimal;

public record PropietarioResponse(
        Integer idUsuario,
        Integer idPerfil,
        String nombre,
        BigDecimal reputacion
) {}