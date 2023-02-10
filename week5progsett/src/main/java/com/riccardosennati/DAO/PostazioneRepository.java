package com.riccardosennati.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.riccardosennati.entity.Postazione;
import com.riccardosennati.entity.TipoPostazione;

public interface PostazioneRepository extends JpaRepository<Postazione, Long>{

	List<Postazione> findByTipo(TipoPostazione tipo);
	
}
