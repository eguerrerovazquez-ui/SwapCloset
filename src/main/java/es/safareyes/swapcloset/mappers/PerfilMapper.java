package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.EstiloResponse;
import es.safareyes.swapcloset.DTO.PerfilRequest;
import es.safareyes.swapcloset.DTO.PerfilResponse;
import es.safareyes.swapcloset.DTO.PrendaResumenResponse;
import es.safareyes.swapcloset.DTO.PropietarioResponse;
import es.safareyes.swapcloset.modelos.Perfil;
import es.safareyes.swapcloset.modelos.Usuario;

import java.util.List;

public final class PerfilMapper {
    private PerfilMapper() {}

    public static Perfil toEntity(PerfilRequest request, Usuario usuario) {
        Perfil perfil = new Perfil();
        perfil.setId_usuario(usuario);
        perfil.setTallacamiseta(request.tallaCamiseta());
        perfil.setTallapantalones(request.tallaPantalones());
        perfil.setTallacalzado(request.tallaCalzado());
        return perfil;
    }

    public static PerfilResponse toResponse(Perfil perfil, List<EstiloResponse> estilos,
                                             List<PrendaResumenResponse> prendas) {
        return new PerfilResponse(perfil.getId(), perfil.getTallacamiseta(), perfil.getTallapantalones(),
                perfil.getTallacalzado(), perfil.getReputacion(), estilos, prendas);
    }

    public static PropietarioResponse toPropietarioResponse(Perfil perfil) {
        Usuario usuario = perfil.getId_usuario();
        return new PropietarioResponse(usuario == null ? null : usuario.getId(), perfil.getId(),
                usuario == null ? null : usuario.getNombre(), perfil.getReputacion());
    }
}