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

    private String title;
    private String start;
    private String end;
    private boolean allDay = false;
    private long id;
    private final SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);

    public EventDTO() {
    }

    public EventDTO(Agenda agenda) {
        this.title = agenda.getAluno().getNomePista();
        Date roundedDate = DateUtils.round(agenda.getDataReserva(), Calendar.HOUR);
        this.setStart(DateUtils.setHours(roundedDate, agenda.getHorario().getTranslatedHourToInt()));
        this.setEnd(DateUtils.addHours(roundedDate, agenda.getQtdeHoras()));
        this.id = agenda.getId();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
