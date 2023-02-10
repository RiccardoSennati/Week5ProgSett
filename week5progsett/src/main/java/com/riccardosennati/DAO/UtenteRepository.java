package com.riccardosennati.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.riccardosennati.entity.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long>{

}
