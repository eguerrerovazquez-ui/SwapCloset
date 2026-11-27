package es.safareyes.swapcloset.servicios;

import es.safareyes.swapcloset.DTO.SolicitudRequest;
import es.safareyes.swapcloset.DTO.SolicitudResponse;

public interface SolicitudService {
    SolicitudResponse crearSolicitud(SolicitudRequest solicitudRequest, Integer idPerfil);
}