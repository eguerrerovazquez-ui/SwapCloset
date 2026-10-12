package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepository extends JpaRepository<Perfil, Integer> {
}
