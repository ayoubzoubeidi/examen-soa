package tn.isi.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.banque.domain.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
}
