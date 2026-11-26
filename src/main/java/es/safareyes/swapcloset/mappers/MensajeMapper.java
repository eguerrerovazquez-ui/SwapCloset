package es.safareyes.swapcloset.mappers;

import es.safareyes.swapcloset.DTO.MensajeRequest;
import es.safareyes.swapcloset.DTO.MensajeResponse;
import es.safareyes.swapcloset.modelos.Mensaje;
import es.safareyes.swapcloset.modelos.Perfil;
import org.springframework.stereotype.Component;

@Component
public class MensajeMapper {
    public Mensaje toEntity(MensajeRequest request, Perfil emisor, Perfil receptor) {
        Mensaje mensaje = new Mensaje();
        mensaje.setPerfile(emisor);
        mensaje.setPerfilr(receptor);
        mensaje.setContenido(request.contenido());
        return mensaje;
    }

    public MensajeResponse toResponse(Mensaje mensaje) {
        return new MensajeResponse(
                mensaje.getId(),
                mensaje.getPerfile() == null ? null : mensaje.getPerfile().getId(),
                mensaje.getPerfilr() == null ? null : mensaje.getPerfilr().getId(),
                mensaje.getFeachaenvio() == null ? null : mensaje.getFeachaenvio().toLocalDateTime(),
                mensaje.getContenido()
        );
    }
}