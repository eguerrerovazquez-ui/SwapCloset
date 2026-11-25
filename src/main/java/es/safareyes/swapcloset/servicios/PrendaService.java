package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.PrendaRequest;
import es.safareyes.swapcloset.DTO.PrendaResponse;
import es.safareyes.swapcloset.DTO.PrendaResumenResponse;
import es.safareyes.swapcloset.modelos.ModalidadIntercambio;
import es.safareyes.swapcloset.modelos.Talla;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PrendaService {
    Page<PrendaResumenResponse> buscarConFiltros(Integer id, String nombre, Talla talla, ModalidadIntercambio modintercambio, String foto, Pageable pageable);

    PrendaResponse obtenerDetalle(Integer id);

    PrendaResponse crearPrenda(PrendaRequest prenda);

    PrendaResponse actualizarPrenda(Integer id, PrendaRequest prenda);

    void eliminarPrenda(Integer id);
}