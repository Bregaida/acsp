/**
 *
 */
package br.com.acsp.curso.domain.agenda;

import br.com.acsp.curso.anotation.Reserva;
import br.com.acsp.curso.common.AbstractDocument;
import br.com.acsp.curso.domain.aeronave.Aeronave;
import br.com.acsp.curso.domain.aluno.Aluno;
import br.com.acsp.curso.domain.aula.Aula;
import br.com.acsp.curso.domain.enums.StatusType;
import br.com.acsp.curso.domain.horario.Horario;
import br.com.acsp.curso.domain.instrutor.Instrutor;
import br.com.acsp.curso.domain.socio.Socio;
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

    private String aeronave;

    private String instrutor;

    private String aula;

    private String aluno;

    private String socio;

    private String horario;

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

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
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

    @Override
    public String toString() {
        return "Agenda{" +
                "dataReserva=" + dataReserva +
                ", aeronave='" + aeronave + '\'' +
                ", instrutor='" + instrutor + '\'' +
                ", aula='" + aula + '\'' +
                ", aluno='" + aluno + '\'' +
                ", socio='" + socio + '\'' +
                ", horario='" + horario + '\'' +
                ", qtdeHoras=" + qtdeHoras +
                ", flag360milhas=" + flag360milhas +
                ", flagVooNoturno=" + flagVooNoturno +
                ", flagVooMatutinoEspecial=" + flagVooMatutinoEspecial +
                ", flagPresenca=" + flagPresenca +
                ", status=" + status +
                '}';
    }
}
