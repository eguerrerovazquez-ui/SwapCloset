package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrendaRepository extends JpaRepository<Prenda, Integer> {
}
