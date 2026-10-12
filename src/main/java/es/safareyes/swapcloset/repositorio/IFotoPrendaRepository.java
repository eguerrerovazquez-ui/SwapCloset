package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.FotoPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFotoPrendaRepository extends JpaRepository<FotoPrenda, Integer> {
}
