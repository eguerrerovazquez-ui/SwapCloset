package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudRepository extends JpaRepository<Solicitud, Integer> {
}
