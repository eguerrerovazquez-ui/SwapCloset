package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {
    @Query(value = """
                    SELECT
                        m.contenido
                    FROM Mensaje m
                    WHERE (m.id_perfilE = :idA AND m.id_perfilR = :idB)
                       OR (m.id_perfilE = :idB AND m.id_perfilR = :idA)
                    ORDER BY m.fechaEnvio ASC;
                    """,nativeQuery = true)
    List<Object[]> mensajes(@Param("idA")Integer idA, @Param("idB")Integer idB);
}

