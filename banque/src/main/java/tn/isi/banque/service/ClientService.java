package tn.isi.banque.service;

import tn.isi.banque.domain.Client;
import tn.isi.banque.domain.Dossier;
import tn.isi.banque.models.CreateDossierRequest;

public interface ClientService {
    Client getClientByCin(String cin);

    void createNew(Client client);

    Dossier createDossier(CreateDossierRequest createDossierRequest);
}
