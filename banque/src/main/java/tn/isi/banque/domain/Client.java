package tn.isi.banque.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    private String cin;

    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    private ContratType contratType;

    @OneToMany(mappedBy = "client")
    private Set<Dossier> dossiers = new HashSet<>();

    private Date dob;

}
