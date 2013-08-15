/**
 *
 */
package br.com.acsp.curso.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author pedrosa
 */

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Calendar dataReserva;


	/*
     *
	 * Atributos :
	 * Data (dia/m�s) 
	 * Lista de Aeronaves dispon�veis 
	 * Horas dispon�veis para aeronave selecionada
	 * Quantidade de horas que o aluno/s�cio quer agendar 
	 * 	(> 16:00 - voo noturno) 
	 * 	(< 08:00 - voo matutino especial) 
	 * Voo 360 Milhas 
	 * Aula (Manobras Altas, TGL, Navega��o, INVA, Acrob�tico) 
	 * Lista Instrutores dispon�veis na horas e habilitado para o tipo de aula selecionado 
	 * 	(obrigado selecionar tipo de aula para agendar com instrutor) 
	 * Status 
	 * 	(Quando aluno agenda Voo noturno, matutino especial, 360 milhas ou com instrutor Status pendente)
	 */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Calendar dataReserva) {
        this.dataReserva = dataReserva;
    }


}
