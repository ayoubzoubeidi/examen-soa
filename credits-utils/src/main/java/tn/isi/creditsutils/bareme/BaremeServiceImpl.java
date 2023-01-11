package tn.isi.creditsutils.bareme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BaremeServiceImpl implements BaremeService {

    private final BaremeRepository baremeRepository;

    @Override
    public Bareme getBaremeByMontantAndDuree(BigDecimal montant, Integer duree) {
        return baremeRepository.getBaremeByMontantAndDuree(montant, duree);
    }
}
