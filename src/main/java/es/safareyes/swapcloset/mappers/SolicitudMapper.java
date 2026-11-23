package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.SolicitudRequest;
import es.safareyes.swapcloset.DTO.SolicitudResponse;
import es.safareyes.swapcloset.modelos.Perfil;
import es.safareyes.swapcloset.modelos.Solicitud;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class SolicitudMapper {
    public Solicitud toEntity(SolicitudRequest request, Perfil solicitante) {
        Solicitud solicitud = new Solicitud();
        solicitud.setId_perfil(solicitante);
        solicitud.setTipo(request.tipo());
        solicitud.setFechainicio(request.fechaInicio() == null ? null : Timestamp.valueOf(request.fechaInicio()));
        solicitud.setFechafin(request.fechaFin() == null ? null : Timestamp.valueOf(request.fechaFin()));
        return solicitud;
    }

    public SolicitudResponse toResponse(Solicitud solicitud, Integer idPerfilDestinatario,
                                       Integer idPrendaSolicitada, Integer idPrendaOfrecida) {
        return new SolicitudResponse(
                solicitud.getId(),
                solicitud.getId_perfil() == null ? null : solicitud.getId_perfil().getId(),
                idPerfilDestinatario,
                idPrendaSolicitada,
                idPrendaOfrecida,
                solicitud.getTipo(),
                solicitud.getEstado() == null ? null : solicitud.getEstado().name(),
                solicitud.getFechacreacion() == null ? null : solicitud.getFechacreacion().toLocalDateTime(),
                solicitud.getFechainicio() == null ? null : solicitud.getFechainicio().toLocalDateTime(),
                solicitud.getFechafin() == null ? null : solicitud.getFechafin().toLocalDateTime(),
                solicitud.getFechacaducidad() == null ? null : solicitud.getFechacaducidad().toLocalDateTime()
        );
    }
}