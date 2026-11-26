package es.safareyes.swapcloset.DTO;

import java.math.BigDecimal;

public record UsuarioAfinResponse(
        Integer idUsuario,
        Integer idPerfil,
        String nombre,
        BigDecimal reputacion,
        long estilosEnComun
) {}