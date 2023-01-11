package tn.isi.creditsutils.score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculScoreRequest {
    private UUID dossierId;
    private BigDecimal salaire;
    private ContratType contratType;
    private BigDecimal mensualite;
    private Boolean isBlackListed;

}
