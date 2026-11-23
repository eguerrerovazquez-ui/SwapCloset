package es.safareyes.swapcloset.DTO;

import es.safareyes.swapcloset.modelos.EstadosMensajes;
import es.safareyes.swapcloset.modelos.ModalidadIntercambio;
import es.safareyes.swapcloset.modelos.Talla;
import java.time.LocalDateTime;
import java.util.List;

public record PrendaResponse(
        Integer id,
        String nombre,
        String descripcion,
        Talla talla,
        ModalidadIntercambio modalidad,
        EstadosMensajes estado,
        LocalDateTime fechaAlta,
        LocalDateTime fechaBaja,
        PropietarioResponse propietario,
        List<CategoriaResponse> categorias,
        List<FotoPrendaResponse> fotos
) {}