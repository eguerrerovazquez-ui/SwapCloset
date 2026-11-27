package es.safareyes.swapcloset.servicios;


import es.safareyes.swapcloset.DTO.PerfilResponse;
import es.safareyes.swapcloset.DTO.UsuarioRequest;
import es.safareyes.swapcloset.DTO.UsuarioResponse;
import es.safareyes.swapcloset.DTO.UsuariosAfinesResponse;
import es.safareyes.swapcloset.mappers.UsuarioMapper;
import es.safareyes.swapcloset.modelos.Perfil;
import es.safareyes.swapcloset.modelos.Usuario;
import es.safareyes.swapcloset.repositorio.IPerfilRepository;
import es.safareyes.swapcloset.repositorio.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final IPerfilRepository perfilRepository;

    public UsuarioServiceImpl(IUsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, IPerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.perfilRepository = perfilRepository;
    }

    @Override
    public UsuarioResponse obtenerPerfilPublico(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con la id: " + id));

        Perfil perfil = perfilRepository.findByUsuarioId(id);

        PerfilResponse perfilResponse = null;
        if (perfil !=null){
            perfilResponse = new PerfilResponse(
                    perfil.getId(),
                    perfil.getTallacamiseta(),
                    perfil.getTallapantalones(),
                    perfil.getTallacalzado(),
                    perfil.getReputacion(),
                    Collections.emptyList(),
                    Collections.emptyList()
            );
        }

        return usuarioMapper.toResponse(usuario, perfilResponse);
    }

    @Override
    public UsuarioResponse actualizacionDePerfil(Integer id, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con la id: " + id));

        usuario.setNombre(request.nombre());
        usuario.setEmail(request.email());

        if (request.fechaNacimiento() != null){
            usuario.setFechaNacimiento(Date.valueOf(request.fechaNacimiento()));
        }

        Usuario usuarioActualizado = usuarioRepository.save(usuario);

        Perfil perfil = perfilRepository.findByUsuarioId(id);
        PerfilResponse perfilResponse = null;
        if (perfil!=null){
            perfilResponse = new PerfilResponse(
                    perfil.getId(),
                    perfil.getTallacamiseta(),
                    perfil.getTallapantalones(),
                    perfil.getTallacalzado(),
                    perfil.getReputacion(),
                    Collections.emptyList(),
                    Collections.emptyList()
            );
        }
        return usuarioMapper.toResponse(usuarioActualizado, perfilResponse);
    }

    @Override
    public List<UsuariosAfinesResponse> obtenerUsuariosAfines(Integer id) {
        List<Object[]> resultados = usuarioRepository.findUsuariosAfines(id);

        return resultados.stream().map(fila -> new UsuariosAfinesResponse(
                        (Integer) fila[0],
                        (String) fila[1],
                        (BigDecimal) fila[2],
                        Arrays.asList(((String) fila[3]).split(","))
                ))
                .collect(Collectors.toList());
    }


}