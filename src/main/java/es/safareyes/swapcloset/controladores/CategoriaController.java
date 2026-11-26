package es.safareyes.swapcloset.controladores;


import es.safareyes.swapcloset.DTO.CategoriaResponse;
import es.safareyes.swapcloset.servicios.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> ListarCategorias(){
        return ResponseEntity.ok(categoriaService.obtenerTodasConConteo());
    }
}