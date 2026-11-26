package es.safareyes.swapcloset.DTO;

import java.time.YearMonth;

public record InformeActividadResponse(
        Integer idCategoria,
        String categoria,
        YearMonth mes,
        long publicaciones,
        long intercambios,
        long prestamos
) {}