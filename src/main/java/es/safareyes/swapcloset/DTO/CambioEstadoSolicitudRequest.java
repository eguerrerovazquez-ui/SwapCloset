package es.safareyes.swapcloset.DTO;

import jakarta.validation.constraints.NotNull;

public record CambioEstadoSolicitudRequest(@NotNull Accion accion) {
    public enum Accion {
        ACEPTAR, RECHAZAR, CANCELAR, FINALIZAR
    }
}