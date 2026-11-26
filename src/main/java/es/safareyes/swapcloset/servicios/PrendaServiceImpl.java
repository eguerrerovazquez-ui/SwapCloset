package es.safareyes.swapcloset.servicios;


import es.safareyes.swapcloset.DTO.PrendaRequest;
import es.safareyes.swapcloset.DTO.PrendaResponse;
import es.safareyes.swapcloset.DTO.PrendaResumenResponse;
import es.safareyes.swapcloset.mappers.PrendaMapper;
import es.safareyes.swapcloset.modelos.ModalidadIntercambio;
import es.safareyes.swapcloset.modelos.Prenda;
import es.safareyes.swapcloset.modelos.Talla;
import es.safareyes.swapcloset.repositorio.IPrendaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaServiceImpl implements PrendaService {

    private final IPrendaRepository prendaRepository;

    public PrendaServiceImpl(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public Page<PrendaResumenResponse> buscarConFiltros(Integer id, String nombre, Talla talla, ModalidadIntercambio modintercambio, String foto, Pageable pageable) {
        Page<Prenda> prendas = prendaRepository.findAll(pageable);
        List<PrendaResumenResponse> listaDtos = prendas.getContent().stream()
                .map(prenda ->{
                    String urlFoto = null;
                    return PrendaMapper.toResumenResponse(prenda,urlFoto);
                })
                .collect(Collectors.toList());
        return new PageImpl<>(listaDtos, pageable,prendas.getTotalElements());
    }

    @Override
    public PrendaResponse obtenerDetalle(Integer id) {
        Prenda prenda = prendaRepository.findWithPerfilById(id)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada"));

        return PrendaMapper.toResponse(prenda, Collections.emptyList(), Collections.emptyList());

    }

    @Override
    public PrendaResponse crearPrenda(PrendaRequest prenda) {
        return null;
    }

    @Override
    public PrendaResponse actualizarPrenda(Integer id, PrendaRequest prenda) {
        return null;
    }

    @Override
    public void eliminarPrenda(Integer id) {

    }

}