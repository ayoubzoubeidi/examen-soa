package tn.isi.creditsutils.score;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;

    @Override
    public Map<String, Evaluation> calculeScore(CalculScoreRequest calculScoreRequest) {
        Map<String, Evaluation> response = new HashMap<>();
        UUID dossierId = calculScoreRequest.getDossierId();
        BigDecimal salaire = calculScoreRequest.getSalaire();
        BigDecimal mentualite = calculScoreRequest.getMensualite();

        Score score = new Score(dossierId);
        Evaluation evaluation = Evaluation.ROUGE;
        Integer calculScore = 0;

        Boolean isBlackListed = calculScoreRequest.getIsBlackListed();

        if (isBlackListed) {
            score.setScore(0);
            score.setEvaluation(evaluation);
            scoreRepository.saveAndFlush(score);
            response.put("evaluation", evaluation);
            return response;
        }


        if (calculScoreRequest.getContratType().equals(ContratType.CDI)) {
            calculScore += 50;
        }

        if (salaire.compareTo(new BigDecimal("2000")) > 0) {
            calculScore += 20;
        }

        if (salaire.compareTo(new BigDecimal("2000")) < 0 && salaire.compareTo(new BigDecimal("1000")) > 0) {
            calculScore += 10;
        }

        if (mentualite.divide(salaire, RoundingMode.HALF_UP).compareTo(new BigDecimal("0.45")) < 0) {
            calculScore += 50;
        }

        if (calculScore > 50) {
            evaluation = Evaluation.VERT;
        }

        score.setScore(calculScore);
        score.setEvaluation(evaluation);

        scoreRepository.saveAndFlush(score);

        response.put("evaluation", evaluation);
        return response;
    }
}
