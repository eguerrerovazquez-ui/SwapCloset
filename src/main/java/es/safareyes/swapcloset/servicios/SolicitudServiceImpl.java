package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.SolicitudRequest;
import es.safareyes.swapcloset.DTO.SolicitudResponse;
import es.safareyes.swapcloset.modelos.Estados;
import es.safareyes.swapcloset.modelos.Perfil;
import es.safareyes.swapcloset.modelos.Prenda;
import es.safareyes.swapcloset.modelos.Solicitud;
import es.safareyes.swapcloset.repositorio.IPerfilRepository;
import es.safareyes.swapcloset.repositorio.IPrendaRepository;
import es.safareyes.swapcloset.repositorio.ISolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final IPerfilRepository perfilRepository;
    private final IPrendaRepository prendaRepository;
    private final ISolicitudRepository solicitudRepository;

    public SolicitudServiceImpl(IPerfilRepository perfilRepository, IPrendaRepository prendaRepository, ISolicitudRepository solicitudRepository) {
        this.perfilRepository = perfilRepository;
        this.prendaRepository = prendaRepository;
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    @Transactional
    public SolicitudResponse crearSolicitud(SolicitudRequest solicitudRequest, Integer idPerfil) {

        Perfil perfilSolicitante = perfilRepository.findById(idPerfil).orElseThrow(() -> new RuntimeException("Perfil no encontrado con id: " + idPerfil));

        Prenda prendaSolicitada = prendaRepository.findById(solicitudRequest.idPrendaSolicitada()).orElseThrow(() -> new RuntimeException("Prenda no encontrada"));

        Perfil perfilDestinatario = prendaSolicitada.getPerfil();

        if (solicitudRequest.idPrendaOfrecida()!=null){
            prendaRepository.findById(solicitudRequest.idPrendaOfrecida()).orElseThrow(() -> new RuntimeException("Prenda no encontrada"));
        }

        Solicitud solicitud = new Solicitud();
        solicitud.setId_perfil(perfilSolicitante);
        solicitud.setTipo(solicitudRequest.tipo());
        solicitud.setEstado(Estados.PENDIENTE);
        solicitud.setFechacreacion(new Timestamp(System.currentTimeMillis()));
        solicitud.setFechainicio(solicitudRequest.fechaInicio() != null ? Timestamp.valueOf(solicitudRequest.fechaInicio()) : null);
        solicitud.setFechafin(solicitudRequest.fechaFin() != null ? Timestamp.valueOf(solicitudRequest.fechaFin()) : null);

        Solicitud solicitudGuardada = solicitudRepository.save(solicitud);

        return new SolicitudResponse(
                solicitudGuardada.getId(),
                perfilSolicitante.getId(),
                perfilDestinatario != null ? perfilDestinatario.getId() : null,
                solicitudRequest.idPrendaSolicitada(),
                solicitudRequest.idPrendaOfrecida(),
                solicitudGuardada.getTipo(),
                solicitudGuardada.getEstado().name(),
                solicitudGuardada.getFechacreacion().toLocalDateTime(),
                solicitudGuardada.getFechainicio() != null ? solicitudGuardada.getFechainicio().toLocalDateTime() : null,
                solicitudGuardada.getFechafin() != null ? solicitudGuardada.getFechafin().toLocalDateTime() : null,
                null
        );
    }
}