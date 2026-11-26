package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.DTO.CategoriaResponse;
import es.safareyes.swapcloset.modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = """
                    SELECT c.nombre, COUNT(pc.id_prenda) AS total_prendas
                    FROM Categoria c
                    LEFT JOIN Prenda_Categoria pc ON pc.id_categoria = c.id
                    GROUP BY c.id, c.nombre
                    ORDER BY total_prendas DESC;
                """, nativeQuery = true)
    List<Object[]> conteoDePrendas();

    @Query("SELECT new es.safareyes.swapcloset.DTO.CategoriaResponse(c.idCategoria, c.nombre, COUNT(p)) " +
            "FROM Categoria c LEFT JOIN c.prendas p " +
            "GROUP BY c.idCategoria, c.nombre " +
            "ORDER BY COUNT(p) DESC")
    List<CategoriaResponse> findAllConConteo();
}
