package com.riccardosennati.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.riccardosennati.entity.Edificio;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepo;
	
	public void put(Edificio p) {
		try {
			edificioRepo.save(p);
			System.out.println(p.toString());
			System.out.println("Inserimento Edificio effettuato con Successo!");
			} catch (Exception e) {
				System.out.println("Errore di Salvataggio!");
			}
	}
}
