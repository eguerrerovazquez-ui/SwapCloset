package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IValoracionRepository extends JpaRepository<Valoracion, Integer> {
}
