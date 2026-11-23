package es.safareyes.swapcloset.DTO;

public record CategoriaResponse(
        Integer id,
        String nombre,
        long prendasDisponibles
) {}