package es.safareyes.swapcloset.DTO;

import java.math.BigDecimal;
import java.util.List;

public record PerfilResponse(
        Integer id,
        String tallaCamiseta,
        String tallaPantalones,
        String tallaCalzado,
        BigDecimal reputacion,
        List<EstiloResponse> estilos,
        List<PrendaResumenResponse> prendas
) {}