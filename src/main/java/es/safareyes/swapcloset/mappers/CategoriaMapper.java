package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.CategoriaRequest;
import es.safareyes.swapcloset.DTO.CategoriaResponse;
import es.safareyes.swapcloset.modelos.Categoria;

public final class CategoriaMapper {
    private CategoriaMapper() {}

    public static Categoria toEntity(CategoriaRequest request) {
        Categoria categoria = new Categoria();
        categoria.setNombre(request.nombre());
        return categoria;
    }

    public static CategoriaResponse toResponse(Categoria categoria, long prendasDisponibles) {
        return new CategoriaResponse(categoria.getIdCategoria(), categoria.getNombre(), prendasDisponibles);
    }
}