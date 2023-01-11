package tn.isi.banque.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    private String cin;

    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    private ContractType contractType;

    private Date dob;

}
