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
    
    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;
    
    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;
    
    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;
    
    @ManyToOne
    @JoinColumn(name = "pista_id")
    private Pista pista;
       
    @Column
    private Integer qtdeHoras;
    
    public boolean isFlag360milhas() {
		return flag360milhas;
	}

	public void setFlag360milhas(boolean flag360milhas) {
		this.flag360milhas = flag360milhas;
	}

	@Column
    private boolean flag360milhas;


	/*
     *
	 * Atributos :
	 * Data (dia/mes) 
	 * Lista de Aeronaves disponíveis
	 * Horas disponíveis para aeronave selecionada
	 * Quantidade de horas que o aluno/soio quer agendar 
	 * 	(> 16:00 - voo noturno) 
	 * 	(< 08:00 - voo matutino especial) 
	 * Voo 360 Milhas 
	 * Aula (Manobras Altas, TGL, Navegacao, INVA, Acrobatico) 
	 * Lista Instrutores disponiveis na horas e habilitado para o tipo de aula selecionado 
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

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

	public Integer getQtdeHoras() {
		return qtdeHoras;
	}

	public void setQtdeHoras(Integer qtdeHoras) {
		this.qtdeHoras = qtdeHoras;
	}


    

}
