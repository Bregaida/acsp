/**
 *
 */
package br.com.acsp.curso.domain;

import br.com.acsp.curso.anotation.Reserva;
import br.com.acsp.curso.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author pedrosa
 */

@Entity
public class Agenda {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5046199074240555898L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @JsonSerialize(using = CustomDateSerializer.class)
    @DateTimeFormat(style = "S-")
	@Column
	@NotNull
	@Reserva
	private Date dataReserva;

    @NotNull
    @ManyToOne
	@JoinColumn(name = "aeronave_id")
	private Aeronave aeronave;

	@ManyToOne
	@JoinColumn(name = "instrutor_id")
	private Instrutor instrutor;

	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "socio_id")
	private Socio socio;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario; 

	@NotNull
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

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
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
	
}
