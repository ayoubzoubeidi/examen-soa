package tn.isi.creditsutils.score;

import java.util.Map;

public interface ScoreService {

    Map<String, Evaluation> calculeScore(CalculScoreRequest calculScoreRequest);

}
