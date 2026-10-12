package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}
