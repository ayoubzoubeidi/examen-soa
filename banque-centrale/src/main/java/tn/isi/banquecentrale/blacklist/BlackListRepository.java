package tn.isi.banquecentrale.blacklist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, String> {
}
