package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.UsuarioRequest;
import es.safareyes.swapcloset.DTO.UsuarioResponse;
import es.safareyes.swapcloset.DTO.UsuariosAfinesResponse;

import java.util.List;

public interface UsuarioService {

    UsuarioResponse obtenerPerfilPublico(Integer id);

    UsuarioResponse actualizacionDePerfil(Integer id, UsuarioRequest request );

    List<UsuariosAfinesResponse> obtenerUsuariosAfines(Integer id);
}