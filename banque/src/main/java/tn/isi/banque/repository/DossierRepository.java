package tn.isi.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.banque.domain.Dossier;

import java.util.UUID;

public interface DossierRepository extends JpaRepository<Dossier, UUID> {
}
