package tn.isi.creditsutils.bareme;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/bareme")
public class BaremeController {

    private final BaremeService baremeService;

    @GetMapping("/{montant}/{duree}")
    public ResponseEntity<?> getBareme(@PathVariable BigDecimal montant, @PathVariable Integer duree) {
        return new ResponseEntity<>(baremeService.getBaremeByMontantAndDuree(montant, duree), HttpStatus.OK);
    }

}
