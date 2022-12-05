import javax.print.attribute.DateTimeSyntax;
import java.util.Date;

public class Consultation {

    private DateTimeSyntax dateTime;
    private int cost;
    private String notes;

    public DateTimeSyntax getDateTime() {
        return dateTime;
    }

    public int getCost() {
        return cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setDateTime(DateTimeSyntax dateTime) {
        this.dateTime = dateTime;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
