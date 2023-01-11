package tn.isi.creditsutils.bareme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

public interface BaremeRepository extends JpaRepository<Bareme, UUID> {


    @Query("FROM Bareme b " +
            "WHERE :montant between b.montantMinimale AND b.montantMaximale " +
            "AND :duree between b.dureeMinimale AND b.dureeMaximale " +
            "ORDER BY b.tauxNominal ASC " +
            "LIMIT 1")
    Bareme getBaremeByMontantAndDuree(@Param("montant") BigDecimal montant, @Param("duree") Integer duree);
}
