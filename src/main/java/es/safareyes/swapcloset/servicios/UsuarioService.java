package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse obtenerPerfilPublico(Integer id);
}