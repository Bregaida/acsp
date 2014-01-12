package br.com.acsp.curso.domain;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: Christian Reichel
 * Date: 9/3/13
 * Time: 10:27 PM
 */
public class EventDTO {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SEPARADOR = "\r\n";

    private String title;
    private String start;
    private String end;
    private boolean allDay = false;
    private String id;
    private final SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);

    public EventDTO() {
    }

    public EventDTO(Agenda agenda) {
        this.title = montaTitulo(agenda);
        Date roundedDate = DateUtils.truncate(agenda.getDataReserva(), Calendar.HOUR);
        Date startDate = DateUtils.setHours(roundedDate, agenda.getHorario().getTranslatedHourToInt());
        this.setStart(startDate);
        this.setEnd(DateUtils.addHours(startDate, agenda.getQtdeHoras()));
        this.id = agenda.getId();
    }

    private String montaTitulo(Agenda agenda) {
        StringBuilder titulo = new StringBuilder();
        titulo.append(agenda.getAluno().getNome()).append(SEPARADOR)
                .append(agenda.getAeronave().toString()).append(SEPARADOR)
                .append(agenda.getInstrutor().getNome()).append(SEPARADOR)
                .append(agenda.getAula().getMateria());
        return titulo.toString();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setStart(Date start) {
        this.start = sdf.format(start);
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setEnd(Date end) {
        this.end = sdf.format(end);
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
