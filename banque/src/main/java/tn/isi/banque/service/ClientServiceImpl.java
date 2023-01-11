package tn.isi.banque.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.banque.domain.Client;
import tn.isi.banque.domain.Dossier;
import tn.isi.banque.models.CreateDossierRequest;
import tn.isi.banque.repository.ClientRepository;
import tn.isi.banque.repository.DossierRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final DossierRepository dossierRepository;

    @Override
    public Client getClientByCin(String cin) {
        return clientRepository.getById(cin);
    }

    @Override
    public void createNew(Client client) {
        clientRepository.saveAndFlush(client);
    }

    @Override
    @Transactional
    public Dossier createDossier(CreateDossierRequest createDossierRequest) {
        Client client = clientRepository.getReferenceById(createDossierRequest.getCin());
        Dossier dossier = new Dossier();
        dossier.setClient(client);
        dossier.setBaremeId(createDossierRequest.getBaremeId());
        dossier.setMontantCredit(createDossierRequest.getMontant());
        dossier.setInteret(createDossierRequest.getMontant().multiply(createDossierRequest.getTauxNominal()));
        dossier.setDureeCredit(createDossierRequest.getDuree());
        dossier.setMensualite((createDossierRequest.getMontant().add(dossier.getInteret())).divide(new BigDecimal(createDossierRequest.getDuree())));
        return dossierRepository.saveAndFlush(dossier);
    }
}
