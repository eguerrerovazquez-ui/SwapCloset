package es.safareyes.swapcloset.DTO;

import es.safareyes.swapcloset.modelos.ModalidadIntercambio;
import es.safareyes.swapcloset.modelos.Talla;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;

public record PrendaRequest(
        @NotBlank String nombre,
        String descripcion,
        @NotNull Talla talla,
        @NotNull ModalidadIntercambio modalidad,
        List<@NotNull @Positive Integer> idsCategorias,
        List<@NotNull @Valid FotoPrendaRequest> fotos
) {}