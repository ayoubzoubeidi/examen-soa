package tn.isi.banque.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @OneToOne(mappedBy = "dossier", cascade = {CascadeType.ALL})
    private Decision decision;

    private BigDecimal montantCredit;

    private UUID baremeId;

    private BigDecimal interet;

    private Integer dureeCredit;

    private BigDecimal mensualite;

}
