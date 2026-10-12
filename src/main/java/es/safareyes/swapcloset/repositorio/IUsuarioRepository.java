package es.safareyes.swapcloset.repositorio;


import es.safareyes.swapcloset.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = """
                SELECT
                    u.id AS id_usuario,
                    u.nombre AS nombre,
                    p.tallaCamiseta AS talla_camiseta,
                    p.tallaPantalones AS talla_pantalones,
                    p.tallaCalzado AS talla_calzado,
                    p.reputacion AS reputacion,
                    (SELECT string_agg(e.tipo, ', ')
                       FROM Perfil_Estilo pe
                       JOIN Estilo e ON e.id = pe.id_estilo
                      WHERE pe.id_perfil = p.id) AS estilos,
                    (SELECT string_agg(pr.nombre, ', ')
                       FROM Prenda pr
                      WHERE pr.id_perfil = p.id) AS prendas
                FROM Usuario u
                JOIN Perfil p ON p.id_usuario = u.id
                WHERE u.id = :id;
                """, nativeQuery = true)
    List<Object[]> infoUsuario(@Param("id") Integer id);
}
