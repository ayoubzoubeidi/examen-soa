package tn.isi.banque.service;

import tn.isi.banque.domain.Client;
import tn.isi.banque.domain.Dossier;
import tn.isi.banque.domain.StatutDecision;
import tn.isi.banque.models.CreateDossierRequest;
import tn.isi.banque.models.Evaluation;

import java.util.UUID;

public interface ClientService {
    Client getClientByCin(String cin);
    void createNew(Client client);
    Dossier createDossier(CreateDossierRequest createDossierRequest);
    StatutDecision makeDecision(UUID dossierId, Evaluation evaluation);
}
