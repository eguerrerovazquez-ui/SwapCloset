package es.safareyes.swapcloset.controladores;


import es.safareyes.swapcloset.DTO.UsuarioRequest;
import es.safareyes.swapcloset.DTO.UsuarioResponse;
import es.safareyes.swapcloset.DTO.UsuariosAfinesResponse;
import es.safareyes.swapcloset.repositorio.IUsuarioRepository;
import es.safareyes.swapcloset.servicios.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

     @PutMapping("/me")
    public ResponseEntity<UsuarioResponse> actualizarPerfil(@RequestParam Integer id, @RequestBody UsuarioRequest request){
         return ResponseEntity.ok(usuarioService.actualizacionDePerfil(id, request));
     }

     @GetMapping("/afines")
    public ResponseEntity<List<UsuariosAfinesResponse>> obtenerUsuariosAfines(@RequestParam Integer id){
         return ResponseEntity.ok(usuarioService.obtenerUsuariosAfines(id));
     }

}