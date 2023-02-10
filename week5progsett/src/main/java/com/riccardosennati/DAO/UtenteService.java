package com.riccardosennati.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.riccardosennati.entity.Utente;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;
	
	public void put(Utente u) {
		try {
		utenteRepo.save(u);
		System.out.println(u.toString());
		System.out.println("Inserimento Utente effettuato con Successo!");
		} catch (Exception e) {
			System.out.println("Errore di Salvataggio!");
		}
		
	}
}