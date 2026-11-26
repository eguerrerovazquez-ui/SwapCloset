package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.FotoPrendaRequest;
import es.safareyes.swapcloset.DTO.FotoPrendaResponse;
import es.safareyes.swapcloset.modelos.FotoPrenda;
import es.safareyes.swapcloset.modelos.Prenda;

public final class FotoPrendaMapper {
    private FotoPrendaMapper() {}

    public static FotoPrenda toEntity(FotoPrendaRequest request, Prenda prenda) {
        FotoPrenda foto = new FotoPrenda();
        foto.setUrl(request.url());
        foto.setOrden(request.orden());
        foto.setId_prenda(prenda);
        return foto;
    }

    public static FotoPrendaResponse toResponse(FotoPrenda foto) {
        return new FotoPrendaResponse(foto.getId(), foto.getUrl(), foto.getOrden());
    }
}