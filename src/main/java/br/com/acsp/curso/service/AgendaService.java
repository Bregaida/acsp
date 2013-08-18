package br.com.acsp.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.acsp.curso.domain.Agenda;
import br.com.acsp.curso.repository.AgendaRepository;

/**
 * @author pedrosa
 */

@Service
public class AgendaService extends AbstractService<Agenda, Long> {


	@Autowired
    public void setRepository(AgendaRepository repository) {
        super.repository = repository;
    }
    
    public static void main(String[] args) {
    	String diaInicial;
    	String datafinal;
    	
    	List<String> listaDatasQuinzenais = new ArrayList<>();
    	
    	LocalDate localDate = new LocalDate();
    	diaInicial = localDate.toString("dd");
    	
    	System.out.println(localDate.toString("dd"));
    	LocalDate moreDays = localDate.plusDays(15);
    	datafinal = moreDays.toString("dd");
    	listaDatasQuinzenais.add(diaInicial + "-" + datafinal );
    	
    	int mes = moreDays.getMonthOfYear();
		System.out.println(mes);
    	
		//TODO Fazer a logica para exibir as datas quinzenais de acordo de 01-16 da data atual
		
		for (String datas : listaDatasQuinzenais) {
			System.out.println(datas);
		}
    	
    	
	}
    

}
