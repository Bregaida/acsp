/**
 *
 */
package br.com.acsp.curso.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * @author pedrosa
 */

@Entity
public class Agenda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date dataReserva;

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
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "socio_id")
	private Socio socio;

	@Column
	private Integer qtdeHoras;

	@Column
	private boolean flag360milhas;

	@Column
	private boolean flagVooNoturno;// >16:00

	@Column
	private boolean flagVooMatutinoEspecial;// <09:00

	@Column
	private boolean flagPresenca;

	@Enumerated(EnumType.STRING)
	private StatusType status;
	
	
	@ManyToMany()
	@JoinTable(name = "agenda_horario", joinColumns = { @JoinColumn(name = "agenda_id") }, inverseJoinColumns = { @JoinColumn(name = "horario_id") })
	private List<Horario> horarios; 
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Integer getQtdeHoras() {
		return qtdeHoras;
	}

	public void setQtdeHoras(Integer qtdeHoras) {
		this.qtdeHoras = qtdeHoras;
	}

	public boolean isFlag360milhas() {
		return flag360milhas;
	}

	public void setFlag360milhas(boolean flag360milhas) {
		this.flag360milhas = flag360milhas;
	}

	public boolean isFlagVooNoturno() {
		return flagVooNoturno;
	}

	public void setFlagVooNoturno(boolean flagVooNoturno) {
		this.flagVooNoturno = flagVooNoturno;
	}

	public boolean isFlagVooMatutinoEspecial() {
		return flagVooMatutinoEspecial;
	}

	public void setFlagVooMatutinoEspecial(boolean flagVooMatutinoEspecial) {
		this.flagVooMatutinoEspecial = flagVooMatutinoEspecial;
	}

	public boolean isFlagPresenca() {
		return flagPresenca;
	}

	public void setFlagPresenca(boolean flagPresenca) {
		this.flagPresenca = flagPresenca;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	
	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	
	
	
}
