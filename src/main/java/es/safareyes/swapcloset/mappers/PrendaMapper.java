package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.CategoriaResponse;
import es.safareyes.swapcloset.DTO.FotoPrendaResponse;
import es.safareyes.swapcloset.DTO.PrendaRequest;
import es.safareyes.swapcloset.DTO.PrendaResponse;
import es.safareyes.swapcloset.DTO.PrendaResumenResponse;
import es.safareyes.swapcloset.modelos.Perfil;
import es.safareyes.swapcloset.modelos.Prenda;

import java.util.List;

public final class PrendaMapper {
    private PrendaMapper() {}

    public static Prenda toEntity(PrendaRequest request, Perfil perfil) {
        Prenda prenda = new Prenda();
        prenda.setPerfil(perfil);
        prenda.setNombre(request.nombre());
        prenda.setDescripcion(request.descripcion());
        prenda.setTalla(request.talla());
        prenda.setModalidad(request.modalidad());
        return prenda;
    }

    public static PrendaResponse toResponse(Prenda prenda, List<CategoriaResponse> categorias,
                                             List<FotoPrendaResponse> fotos) {
        return new PrendaResponse(prenda.getId(), prenda.getNombre(), prenda.getDescripcion(),
                prenda.getTalla(), prenda.getModalidad(), prenda.getEstado(),
                prenda.getFechaalta() == null ? null : prenda.getFechaalta().toLocalDateTime(),
                prenda.getFechabaja() == null ? null : prenda.getFechabaja().toLocalDateTime(),
                prenda.getPerfil() == null ? null : PerfilMapper.toPropietarioResponse(prenda.getPerfil()),
                categorias, fotos);
    }

    public static PrendaResumenResponse toResumenResponse(Prenda prenda, String fotoPrincipal) {
        return new PrendaResumenResponse(prenda.getId(), prenda.getNombre(), prenda.getTalla(),
                prenda.getModalidad(), fotoPrincipal);
    }
}