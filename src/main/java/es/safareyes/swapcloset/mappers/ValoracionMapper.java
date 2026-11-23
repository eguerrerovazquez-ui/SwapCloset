package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.ValoracionRequest;
import es.safareyes.swapcloset.DTO.ValoracionResponse;
import es.safareyes.swapcloset.modelos.Perfil;
import es.safareyes.swapcloset.modelos.Solicitud;
import es.safareyes.swapcloset.modelos.Valoracion;
import org.springframework.stereotype.Component;

@Component
public class ValoracionMapper {
    public Valoracion toEntity(ValoracionRequest request, Perfil perfil, Solicitud solicitud) {
        Valoracion valoracion = new Valoracion();
        valoracion.setId_perfil(perfil);
        valoracion.setId_solicitud(solicitud);
        valoracion.setPuntuacion(request.puntuacion());
        valoracion.setComentario(request.comentario());
        return valoracion;
    }

    public ValoracionResponse toResponse(Valoracion valoracion) {
        return new ValoracionResponse(
                valoracion.getId(),
                valoracion.getId_solicitud() == null ? null : valoracion.getId_solicitud().getId(),
                valoracion.getId_perfil() == null ? null : valoracion.getId_perfil().getId(),
                valoracion.getPuntuacion(),
                valoracion.getComentario(),
                valoracion.getFecha() == null ? null : valoracion.getFecha().toLocalDateTime()
        );
    }
}