package es.safareyes.swapcloset.repositorio;


import es.safareyes.swapcloset.modelos.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    Optional<Usuario> findById(Integer id);

    @EntityGraph(attributePaths = {"perfil", "perfil.estilos", "perfil.prendas"})
    Optional<Usuario> findWithPerfilEstilosAndPrendasById(Integer id);

    @Query(value = """
    SELECT u.id, u.nombre, p.reputacion, 
           STRING_AGG(e.tipo, ', ') AS estilos_comunes
    FROM usuario u
    JOIN perfil p ON p.id_usuario = u.id
    JOIN perfil_estilo pe ON pe.id_perfil = p.id
    JOIN estilo e ON e.id = pe.id_estilo
    WHERE u.id != :idUsuario
      AND e.id IN (
          SELECT pe2.id_estilo 
          FROM perfil_estilo pe2 
          JOIN perfil p2 ON p2.id = pe2.id_perfil 
          WHERE p2.id_usuario = :idUsuario
      )
    GROUP BY u.id, u.nombre, p.reputacion
    ORDER BY p.reputacion DESC
    """, nativeQuery = true)
    List<Object[]> findUsuariosAfines(@Param("idUsuario") Integer id);
}
