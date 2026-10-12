package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISolicitudRepository extends JpaRepository<Solicitud, Integer> {
    @Query(value = """
                    SELECT tipo, estado, fechaCreacion
                    FROM Solicitud
                    WHERE id_perfil = :idPerfil
                    """, nativeQuery = true)
    List<Object[]> solicitudesEnCurso(@Param("idPerfil")Integer id);

    //Estos dos son para la consulta grande final

    @Query(value = """
    SELECT c.nombre                          AS categoria,
           TO_CHAR(s.fechaFin, 'YYYY-MM')    AS mes,
           COUNT(*)                          AS total
    FROM solicitud s
    JOIN prenda pr           ON pr.id_perfil = s.id_perfil
    JOIN prenda_categoria pc ON pc.id_prenda = pr.id
    JOIN categoria c         ON c.id = pc.id_categoria
    WHERE s.tipo = 'INTERCAMBIO'
      AND s.estado = 'FINALIZADA'
      AND s.fechaFin IS NOT NULL
    GROUP BY c.nombre, TO_CHAR(s.fechaFin, 'YYYY-MM')
    ORDER BY c.nombre, mes
    """, nativeQuery = true)
    List<Object[]> intercambiosPorCategoriaYMes();

    @Query(value = """
    SELECT c.nombre                          AS categoria,
           TO_CHAR(s.fechaFin, 'YYYY-MM')    AS mes,
           COUNT(*)                          AS total
    FROM solicitud s
    JOIN prenda pr           ON pr.id_perfil = s.id_perfil
    JOIN prenda_categoria pc ON pc.id_prenda = pr.id
    JOIN categoria c         ON c.id = pc.id_categoria
    WHERE s.tipo = 'PRESTAMO'
      AND s.estado = 'FINALIZADA'
      AND s.fechaFin IS NOT NULL
    GROUP BY c.nombre, TO_CHAR(s.fechaFin, 'YYYY-MM')
    ORDER BY c.nombre, mes
    """, nativeQuery = true)
    List<Object[]> prestamosPorCategoriaYMes();
}
