package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.EstiloRequest;
import es.safareyes.swapcloset.DTO.EstiloResponse;
import es.safareyes.swapcloset.modelos.Estilo;

public final class EstiloMapper {
    private EstiloMapper() {}

    public static Estilo toEntity(EstiloRequest request) {
        Estilo estilo = new Estilo();
        estilo.setTipo(request.tipo());
        return estilo;
    }

    public static EstiloResponse toResponse(Estilo estilo) {
        return new EstiloResponse(estilo.getId(), estilo.getTipo());
    }
}