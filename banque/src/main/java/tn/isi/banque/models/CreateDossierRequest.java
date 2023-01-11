package tn.isi.banque.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDossierRequest {

    private String cin;
    private UUID baremeId;
    private BigDecimal tauxNominal;
    private Integer duree;
    private BigDecimal montant;

}
