package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Integer> {
    @Query(value = """
                    SELECT u.nombre,
                           a.reputacion,
                           COUNT(DISTINCT c.id_estilo) AS estilos_en_comun
                    FROM perfil a
                    JOIN usuario u           ON u.id = a.id_usuario
                    LEFT JOIN perfil_estilo b ON b.id_perfil = a.id
                    LEFT JOIN perfil_estilo c ON c.id_estilo = b.id_estilo
                                             AND c.id_perfil <> a.id
                    GROUP BY a.id, u.nombre, a.reputacion
                    ORDER BY estilos_en_comun DESC, a.reputacion DESC
                    """, nativeQuery = true)
    List<Object[]> perfilesConEstilosEnComun();
}
