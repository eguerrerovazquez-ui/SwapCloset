package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;

public record PerfilRequest(
        String tallaCamiseta,
        String tallaPantalones,
        String tallaCalzado,
        @NotNull List<@NotNull @Positive Integer> idsEstilos
) {}