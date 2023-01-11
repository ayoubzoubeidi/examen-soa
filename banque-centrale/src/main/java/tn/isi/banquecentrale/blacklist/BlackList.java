package tn.isi.banquecentrale.blacklist;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlackList {

    @Id
    private String cin;

    private Boolean isBlackList;

}
