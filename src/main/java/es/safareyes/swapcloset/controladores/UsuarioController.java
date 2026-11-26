package es.safareyes.swapcloset.controladores;


import es.safareyes.swapcloset.DTO.UsuarioResponse;
import es.safareyes.swapcloset.repositorio.IUsuarioRepository;
import es.safareyes.swapcloset.servicios.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
     private final UsuarioService usuarioService;

     public UsuarioController(UsuarioService usuarioService) {
         this.usuarioService = usuarioService;
     }

     @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerPerfilPublico(@PathVariable Integer id){
         return ResponseEntity.ok(usuarioService.obtenerPerfilPublico(id));
     }

}