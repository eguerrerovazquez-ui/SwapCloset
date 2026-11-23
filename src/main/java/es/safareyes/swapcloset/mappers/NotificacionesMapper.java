package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.NotificacionesRequest;
import es.safareyes.swapcloset.DTO.NotificacionesResponse;
import es.safareyes.swapcloset.modelos.Notificaciones;
import es.safareyes.swapcloset.modelos.Perfil;
import org.springframework.stereotype.Component;

@Component
public class NotificacionesMapper {
    public Notificaciones toEntity(NotificacionesRequest request, Perfil perfil) {
        Notificaciones notificacion = new Notificaciones();
        notificacion.setId_perfil(perfil);
        notificacion.setTipo(request.tipo());
        notificacion.setTexto(request.texto());
        return notificacion;
    }

    public NotificacionesResponse toResponse(Notificaciones notificacion) {
        return new NotificacionesResponse(
                notificacion.getId(),
                notificacion.getId_perfil() == null ? null : notificacion.getId_perfil().getId(),
                notificacion.getTipo(),
                notificacion.getTexto(),
                notificacion.getFecha() == null ? null : notificacion.getFecha().toLocalDateTime(),
                notificacion.getFechaleida() == null ? null : notificacion.getFechaleida().toLocalDateTime()
        );
    }
}