package es.safareyes.swapcloset.DTO;

import java.math.BigDecimal;
import java.util.List;

public record UsuariosAfinesResponse (
        Integer id,
        String nombre,
        BigDecimal reputacion,
        List<String> estilosComunes
){}
