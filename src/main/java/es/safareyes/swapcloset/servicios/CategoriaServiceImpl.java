package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.CategoriaResponse;
import es.safareyes.swapcloset.repositorio.ICategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final ICategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaResponse> obtenerTodasConConteo() {
        return categoriaRepository.findAllConConteo();
    }
}