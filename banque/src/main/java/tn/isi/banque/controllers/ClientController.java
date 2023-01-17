package tn.isi.banque.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.isi.banque.domain.Client;
import tn.isi.banque.models.CreateDossierRequest;
import tn.isi.banque.models.Evaluation;
import tn.isi.banque.service.ClientService;

import java.util.UUID;



@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{cin}")
    public ResponseEntity<?> getClientByCin(@PathVariable String cin) {
        return new ResponseEntity<>(clientService.getClientByCin(cin), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        clientService.createNew(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/dossier")
    public ResponseEntity<?> saveDossier(@RequestBody CreateDossierRequest createDossierRequest) {
        return new ResponseEntity<>(clientService.createDossier(createDossierRequest), HttpStatus.CREATED);
    }

    @PostMapping("/decision/{dossierId}/{evaluation}")
    public ResponseEntity<?> makeDecision(@PathVariable UUID dossierId, @PathVariable Evaluation evaluation) {
        return new ResponseEntity<>(clientService.makeDecision(dossierId, evaluation), HttpStatus.CREATED);
    }


}
