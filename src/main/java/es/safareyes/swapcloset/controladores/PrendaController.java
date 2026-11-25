package es.safareyes.swapcloset.controladores;


import es.safareyes.swapcloset.DTO.PrendaRequest;
import es.safareyes.swapcloset.DTO.PrendaResponse;
import es.safareyes.swapcloset.DTO.PrendaResumenResponse;
import es.safareyes.swapcloset.modelos.ModalidadIntercambio;
import es.safareyes.swapcloset.modelos.Talla;
import es.safareyes.swapcloset.servicios.PrendaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prendas")
public class PrendaController {
     private final PrendaService prendaService;

     public PrendaController(PrendaService prendaService) {
         this.prendaService = prendaService;
     }

    @GetMapping
    public ResponseEntity<Page<PrendaResumenResponse>> buscarPrendas(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Talla talla,
            @RequestParam(required = false) ModalidadIntercambio modintercambio,
            @RequestParam(required = false) String foto,
            @ParameterObject Pageable pageable) {

        Page<PrendaResumenResponse> resultado = prendaService.buscarConFiltros(
                id, nombre, talla, modintercambio, foto, pageable);

        return ResponseEntity.ok(prendaService.buscarConFiltros(id, nombre, talla, modintercambio, foto, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrendaResponse> obtenerDetalle(@PathVariable Integer id) {
         return ResponseEntity.ok(prendaService.obtenerDetalle(id));
    }

    @PostMapping
    public ResponseEntity<PrendaResponse> publicarPrenda(@RequestBody PrendaRequest prendaRequest) {
         PrendaResponse nueva = prendaService.crearPrenda(prendaRequest);
         return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendaResponse> actualizarPrenda(@PathVariable Integer id, @RequestBody PrendaRequest prendaRequest) {
         return ResponseEntity.ok(prendaService.actualizarPrenda(id, prendaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrenda(@PathVariable Integer id) {
        prendaService.eliminarPrenda(id);
        return ResponseEntity.noContent().build();
    }
}