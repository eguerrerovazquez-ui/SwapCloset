package es.safareyes.swapcloset.controladores;

import es.safareyes.swapcloset.DTO.SolicitudRequest;
import es.safareyes.swapcloset.DTO.SolicitudResponse;
import es.safareyes.swapcloset.servicios.SolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<SolicitudResponse> crearSolicitud(@RequestBody SolicitudRequest solicitudRequest, @RequestParam Integer idPerfil) {
        SolicitudResponse nueva = solicitudService.crearSolicitud(solicitudRequest, idPerfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

}