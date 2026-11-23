package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.PerfilResponse;
import es.safareyes.swapcloset.DTO.UsuarioRequest;
import es.safareyes.swapcloset.DTO.UsuarioResponse;
import es.safareyes.swapcloset.modelos.Usuario;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Objects;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioRequest request, String contrasenaCodificada) {
        Objects.requireNonNull(contrasenaCodificada, "La contraseña debe estar codificada");
        Usuario usuario = new Usuario();
        usuario.setNombre(request.nombre());
        usuario.setEmail(request.email());
        usuario.setContrasena(contrasenaCodificada);
        usuario.setFechaNacimiento(request.fechaNacimiento() == null ? null : Date.valueOf(request.fechaNacimiento()));
        return usuario;
    }

    public UsuarioResponse toResponse(Usuario usuario, PerfilResponse perfil) {
        return new UsuarioResponse(usuario.getId(), usuario.getNombre(), perfil);
    }
}