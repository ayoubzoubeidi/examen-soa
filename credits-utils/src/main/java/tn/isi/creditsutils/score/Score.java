package tn.isi.creditsutils.score;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @Id
    private UUID dossierId;

    private Integer score;

    private Evaluation evaluation;

    public Score(UUID dossierId) {
        this.dossierId = dossierId;
    }
}
