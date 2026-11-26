package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.CategoriaResponse;

import java.util.List;

public interface CategoriaService {
    List<CategoriaResponse> obtenerTodasConConteo();
}