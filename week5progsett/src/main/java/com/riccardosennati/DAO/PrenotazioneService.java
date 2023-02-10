package com.riccardosennati.DAO;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riccardosennati.entity.Postazione;
import com.riccardosennati.entity.Prenotazione;
import com.riccardosennati.entity.Utente;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;
	
	public void put(Prenotazione p) {
		try {
			prenotazioneRepo.save(p);
			System.out.println("Prenotazione effettuata con Successo: ");
			System.out.println(p.toString());
			} catch (Exception e) {
				System.out.println("Errore di Salvataggio!");
			}
	}

	public boolean verificaPrenota(Utente utente, Postazione p, LocalDate data) {
		List<Prenotazione> result = prenotazioneRepo.findByData(data).stream().filter(l -> l.getUtente().getId() == utente.getId()).toList();
		if (prenotazioneRepo.countByData(data) >= p.getMaxPartecipanti()) {
			System.out.println("Siamo spiacenti, la postazione e gia al completo");
			return false;
		} else if (result.size() > 0) {
			System.out.println("Siamo spiacenti non puoi effettuare piu prenotazioni per la stessa data");
			return false;
		} else {
			return true;
		}
	}
}
