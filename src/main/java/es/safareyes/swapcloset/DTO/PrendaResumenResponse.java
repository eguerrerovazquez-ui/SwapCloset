package es.safareyes.swapcloset.DTO;

import es.safareyes.swapcloset.modelos.ModalidadIntercambio;
import es.safareyes.swapcloset.modelos.Talla;

public record PrendaResumenResponse(
        Integer id,
        String nombre,
        Talla talla,
        ModalidadIntercambio modalidad,
        String fotoPrincipal
) {}