package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.CategoriaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Override
    public List<CategoriaResponse> obtenerTodasConConteo() {
        return List.of();
    }
}