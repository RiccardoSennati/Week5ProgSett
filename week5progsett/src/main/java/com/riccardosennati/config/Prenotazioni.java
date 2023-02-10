package com.riccardosennati.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.riccardosennati.entity.Edificio;
import com.riccardosennati.entity.Postazione;
import com.riccardosennati.entity.TipoPostazione;


@Configuration
public class Prenotazioni {

	@Bean
	public Edificio edificioMP() {
		return new Edificio().builder().nome("Marco Polo").citta("Roma").indirizzo("Scalo San Lorenzo").build();
	}
	@Bean
	public Postazione postazione1(Edificio e1) {
		return new Postazione().builder().descrizione("Postazione da 1").tipo(TipoPostazione.PRIVATO).maxPartecipanti(1).edificio(e1).build();
	}
	@Bean
	public Postazione postazione5(Edificio e1) {
		return new Postazione().builder().descrizione("Postazione da 5").tipo(TipoPostazione.SALARIUNIONI).maxPartecipanti(5).edificio(e1).build();
	}
	@Bean
	public Postazione postazione10(Edificio e1) {
		return new Postazione().builder().descrizione("Postazione da 10").tipo(TipoPostazione.OPENSPACE).maxPartecipanti(10).edificio(e1).build();
	}
}
