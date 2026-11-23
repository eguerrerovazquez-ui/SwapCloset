package es.safareyes.swapcloset.DTO;

public record UsuarioResponse(
        Integer id,
        String nombre,
        PerfilResponse perfil
) {}