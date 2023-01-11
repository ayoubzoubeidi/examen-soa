package tn.isi.creditsutils.score;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping
    public ResponseEntity<?> calculerScore(@RequestBody CalculScoreRequest calculScoreRequest) {
        return new ResponseEntity<>(scoreService.calculeScore(calculScoreRequest), HttpStatus.CREATED);
    }

}
