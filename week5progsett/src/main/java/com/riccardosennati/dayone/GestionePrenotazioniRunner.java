package com.riccardosennati.dayone;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.riccardosennati.DAO.EdificioService;
import com.riccardosennati.DAO.PostazioneService;
import com.riccardosennati.DAO.PrenotazioneService;
import com.riccardosennati.DAO.UtenteService;
import com.riccardosennati.config.Prenotazioni;
import com.riccardosennati.entity.Edificio;
import com.riccardosennati.entity.Postazione;
import com.riccardosennati.entity.Prenotazione;
import com.riccardosennati.entity.TipoPostazione;
import com.riccardosennati.entity.Utente;

@Component
public class GestionePrenotazioniRunner implements CommandLineRunner {

	@Autowired
	EdificioService es;
	@Autowired
	PostazioneService pos;
	@Autowired
	PrenotazioneService prs;
	@Autowired
	UtenteService us;

	Logger logger = LoggerFactory.getLogger(GestionePrenotazioniRunner.class);

	ApplicationContext ctx = new AnnotationConfigApplicationContext(Prenotazioni.class);

	public static String space = System.lineSeparator();
	public static String divisor = "*********************************************************************"
;	@Override
	public void run(String... args) throws Exception {


	//EDIFICIO
		System.out.println(space);
		System.out.println(" --- GESTIONE PRENOTAZIONI ---");
		System.out.println(space);
		System.out.println(" --- CREAZIONE ENTITY ---");
		System.out.println(space);
		System.out.println("- Creazione Edificio -");
		Edificio e1 = (Edificio) ctx.getBean("edificioMP");
		es.put(e1);
		System.out.println(space);

	//POSTAZIONI
		System.out.println("- Creazione Postazione -");
		Postazione po1 = (Postazione) ctx.getBean("postazione1", e1);
		pos.put(po1);
		System.out.println(space);
		System.out.println("- Creazione Postazione -");
		Postazione po2 = (Postazione) ctx.getBean("postazione5", e1);
		pos.put(po2);
		System.out.println(space);
		System.out.println("- Creazione Postazione -");
		Postazione po3 = (Postazione) ctx.getBean("postazione10", e1);
		pos.put(po3);
		System.out.println(space);

	//UTENTI
		System.out.println("- Creazione Utente -");
		Utente u1 = new Utente().builder().username("Riccardo21").nome("Riccardo").email("riccardo.sen@email.it").build();
		us.put(u1);
		System.out.println(space);
		System.out.println("- Creazione Utente -");
		Utente u2 = new Utente().builder().username("Alice27").nome("Alice").email("alice.sen@email.it").build();
		us.put(u2);
		System.out.println(space);

		System.out.println(space);
		System.out.println(" --- PRENOTAZIONI ---");
		System.out.println(space);
		
	//PRENOTAZIONI
		System.out.println("--- Inserimento prenotazione ---");
		prenota(u1, po1, LocalDate.now());
		System.out.println(space);
		
		System.out.println("- Inserimento di una prenotazione di un utente che ha gia prenotato in data selezionata -");
		prenota(u1, po2, LocalDate.now());
		System.out.println(space);
		
		System.out.println("- Inserimento di una prenotazione di un utente che ha gia prenotato in data diversa dalla selezionata -");
		prenota(u1, po2, LocalDate.now().plusDays(3));
		System.out.println(space);

		System.out.println("- Inserimento di una prenotazione con postazione piena -");
		prenota(u2, po1, LocalDate.now());
		System.out.println(space);
		
		
		System.out.println(space);
		System.out.println(" ---- RICERCA ----");
		System.out.println(space);
		
		System.out.println("- Ricerca Postazioni per Tipo: -");
		pos.getByTipo(TipoPostazione.PRIVATO);
		System.out.println(space);
		
		System.out.println("- Ricerca Postazioni per Citta: -");
		pos.getByCitta("Roma");
		System.out.println(space);
		
		
		((AnnotationConfigApplicationContext) ctx).close();

	}

	public void prenota(Utente utente, Postazione p, LocalDate data) {
		if (prs.verificaPrenota(utente, p, data)) {
			Prenotazione pr = new Prenotazione().builder().data(data).postazione(p).utente(utente).build();
			prs.put(pr);
		} else {
			System.out.println("impossibile effettuare la prenotazione");
		}
	}
	


}