package es.safareyes.swapcloset.servicios;


import es.safareyes.swapcloset.DTO.FotoPrendaRequest;
import es.safareyes.swapcloset.DTO.PrendaRequest;
import es.safareyes.swapcloset.DTO.PrendaResponse;
import es.safareyes.swapcloset.DTO.PrendaResumenResponse;
import es.safareyes.swapcloset.mappers.PrendaMapper;
import es.safareyes.swapcloset.modelos.*;
import es.safareyes.swapcloset.repositorio.ICategoriaRepository;
import es.safareyes.swapcloset.repositorio.IFotoPrendaRepository;
import es.safareyes.swapcloset.repositorio.IPrendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaServiceImpl implements PrendaService {

    private final IPrendaRepository prendaRepository;
    private final ICategoriaRepository categoriaRepository;
    private final IFotoPrendaRepository fotoPrendaRepository;

    public PrendaServiceImpl(IPrendaRepository prendaRepository, ICategoriaRepository categoriaRepository, IFotoPrendaRepository fotoPrendaRepository) {
        this.prendaRepository = prendaRepository;
        this.categoriaRepository = categoriaRepository;
        this.fotoPrendaRepository = fotoPrendaRepository;
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
    @Transactional
    public PrendaResponse crearPrenda(PrendaRequest prendaRequest) {
        Perfil perfilPrueba = new Perfil();
        perfilPrueba.setId(1);

        Prenda prenda = PrendaMapper.toEntity(prendaRequest, perfilPrueba);

        prenda.setFechaalta(new Timestamp(System.currentTimeMillis()));

        prenda.setEstado(EstadosMensajes.BORRADOR);

        Prenda prendaGuardada = prendaRepository.save(prenda);

        if (prendaRequest.idsCategorias() != null && !prendaRequest.idsCategorias().isEmpty()) {
            List<Categoria> categorias = categoriaRepository.findAllById(prendaRequest.idsCategorias());
            for (Categoria categoria : categorias) {
                categoria.getPrendas().add(prendaGuardada);
                categoriaRepository.save(categoria);
            }
        }

        if (prendaRequest.fotos() != null && !prendaRequest.fotos().isEmpty()) {
            for (FotoPrendaRequest fotoRequest : prendaRequest.fotos()) {
                FotoPrenda foto = new FotoPrenda();
                foto.setUrl(fotoRequest.url());
                foto.setOrden(fotoRequest.orden());
                foto.setId_prenda(prendaGuardada);
                fotoPrendaRepository.save(foto);
            }
        }

        return PrendaMapper.toResponse(prendaGuardada, Collections.emptyList(), Collections.emptyList());
    }

    @Override
    @Transactional
    public PrendaResponse actualizarPrenda(Integer id, PrendaRequest prendaRequest) {
        Prenda prendaExistente = prendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Prenda no encontrada con la id: " + id));

        prendaExistente.setNombre(prendaRequest.nombre());
        prendaExistente.setDescripcion(prendaRequest.descripcion());
        prendaExistente.setTalla(prendaRequest.talla());
        prendaExistente.setModalidad(prendaRequest.modalidad());

        Prenda prendaActualizada = prendaRepository.save(prendaExistente);
        return PrendaMapper.toResponse(prendaActualizada, Collections.emptyList(), Collections.emptyList());
    }

    @Override
    @Transactional
    public void eliminarPrenda(Integer id) {
        Prenda prenda = prendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Prenda no encontrada con la id: " + id));

        prenda.setEstado(EstadosMensajes.RETIRADA);

        prenda.setFechabaja(new Timestamp(System.currentTimeMillis()));

        prendaRepository.save(prenda);
    }

}