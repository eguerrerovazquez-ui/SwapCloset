package es.safareyes.swapcloset.servicios;


import es.safareyes.swapcloset.DTO.UsuarioResponse;
import es.safareyes.swapcloset.mappers.UsuarioMapper;
import es.safareyes.swapcloset.modelos.Perfil;
import es.safareyes.swapcloset.modelos.Usuario;
import es.safareyes.swapcloset.repositorio.IPerfilRepository;
import es.safareyes.swapcloset.repositorio.IUsuarioRepository;
import org.springframework.stereotype.Service;

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
        Usuario usuario = usuarioRepository.findWithPerfilEstilosAndPrendasById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con la id: " + id));

        //Perfil perfil = perfilRepository.findByIdUsuario(id).orElseThrow(() -> new RuntimeException("Perfil no encontrado para el usuario con la id: " + id));

        return null;
    }

}