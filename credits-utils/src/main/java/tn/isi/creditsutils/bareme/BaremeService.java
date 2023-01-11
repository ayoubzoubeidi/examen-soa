package tn.isi.creditsutils.bareme;

import java.math.BigDecimal;

public interface BaremeService {

    Bareme getBaremeByMontantAndDuree(BigDecimal montant, Integer duree);

}
