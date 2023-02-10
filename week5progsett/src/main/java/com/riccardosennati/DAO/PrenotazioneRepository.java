package com.riccardosennati.DAO;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.riccardosennati.entity.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{
	
	long countByData(LocalDate data);

	List<Prenotazione> findByData(LocalDate data);
}
