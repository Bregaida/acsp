/**
 *
 */
package br.com.acsp.curso.domain;

import br.com.acsp.curso.anotation.Reserva;
import br.com.acsp.curso.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author pedrosa
 */
@Document
public class Agenda extends AbstractDocument {

    @JsonSerialize(using = CustomDateSerializer.class)
    @DateTimeFormat(style = "S-")
    @NotNull
    @Reserva
    private Date dataReserva;

    @NotNull
    @DBRef
    private Aeronave aeronave;

    @DBRef
    private Instrutor instrutor;

    private Aula aula;

    @NotNull
    @DBRef
    private Aluno aluno;

    @DBRef
    private Socio socio;

    @NotNull
    private Horario horario;

    @NotNull
    private Integer qtdeHoras;

    private boolean flag360milhas;

    private boolean flagVooNoturno;// >16:00

    private boolean flagVooMatutinoEspecial;// <09:00

    private boolean flagPresenca;

    private StatusType status;

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
