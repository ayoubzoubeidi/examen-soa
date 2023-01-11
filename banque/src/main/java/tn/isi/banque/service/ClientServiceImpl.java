package tn.isi.banque.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.banque.domain.Client;
import tn.isi.banque.domain.Decision;
import tn.isi.banque.domain.Dossier;
import tn.isi.banque.domain.StatutDecision;
import tn.isi.banque.models.CreateDossierRequest;
import tn.isi.banque.models.Evaluation;
import tn.isi.banque.repository.ClientRepository;
import tn.isi.banque.repository.DossierRepository;

import java.math.BigDecimal;
import java.util.UUID;

import static tn.isi.banque.domain.StatutDecision.ACCEPTATION;
import static tn.isi.banque.domain.StatutDecision.RUFUS;

@Service
@RequiredArgsConstructor
@Transactional
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

    @Override
    public StatutDecision makeDecision(UUID dossierId, Evaluation evaluation) {
        Dossier dossier = dossierRepository.getById(dossierId);
        StatutDecision statutDecision = evaluation.equals(Evaluation.VERT) ? ACCEPTATION : RUFUS;
        Decision decision = new Decision();
        decision.setStatutDecision(statutDecision);
        decision.setDossier(dossier);
        dossier.setDecision(decision);
        dossier = dossierRepository.saveAndFlush(dossier);
        return dossier.getDecision().getStatutDecision();
    }
}
