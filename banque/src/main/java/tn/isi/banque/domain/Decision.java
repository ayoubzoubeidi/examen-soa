package tn.isi.banque.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Decision {

    @Id
    @OneToOne
    @JoinColumn(name = "dossier_id")
    private Dossier dossier;

    @CreationTimestamp
    private Timestamp dateDecision;

    private StatutDecision statutDecision;

    public Decision(Dossier dossier, StatutDecision statutDecision) {
        this.dossier = dossier;
        this.statutDecision = statutDecision;
    }
}
