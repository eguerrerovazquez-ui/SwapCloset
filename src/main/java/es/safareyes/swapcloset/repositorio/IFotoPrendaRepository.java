package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.FotoPrenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFotoPrendaRepository extends JpaRepository<FotoPrenda, Integer> {
}
