package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Estados;
import es.safareyes.swapcloset.modelos.EstadosMensajes;
import es.safareyes.swapcloset.modelos.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, Integer> {

    List<Prenda> findByEstado(EstadosMensajes estado);

    @Query(value = """
                    select p.id, f.url, u.nombre, v.puntuacion from prenda p
                    left join fotoprenda f
                    on p.id = f.id_prenda
                    left join perfil pe
                    on pe.id = p.id_perfil
                    left join usuario u
                    on u.id = pe.id_usuario
                    left join valoracion v\s
                    on pe.id = v.id_perfil
                    where p.id = :id
                """, nativeQuery = true)
    List<Object[]> detalleDePrenda(@Param("id")Integer id);

    @Query(value = """
    SELECT c.nombre                          AS categoria,
           TO_CHAR(p.fechaAlta, 'YYYY-MM')   AS mes,
           COUNT(*)                          AS total
    FROM prenda p
    JOIN prenda_categoria pc ON pc.id_prenda = p.id
    JOIN categoria c         ON c.id = pc.id_categoria
    GROUP BY c.nombre, TO_CHAR(p.fechaAlta, 'YYYY-MM')
    ORDER BY c.nombre, mes
    """, nativeQuery = true)
    List<Object[]> publicacionesPorCategoriaYMes();

    //1 de 3 para la consulta grande
}
