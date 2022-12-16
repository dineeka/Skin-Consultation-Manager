import javax.print.attribute.DateTimeSyntax;
import java.util.Date;

public class Consultation {

    private DateTimeSyntax dateTime;
    private int cost;
    private String notes;

    public Consultation(){}

    /**
     * @param dateTime
     * @param price
     * @param notes
     */
    public Consultation(DateTimeSyntax dateTime, int price, String notes){
        this.dateTime = dateTime;
        this.cost = price;
        this.notes = notes;
    }

    /**
     * @return
     */
    public DateTimeSyntax getDateTime() {
        return dateTime;
    }

    /**
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param dateTime
     */
    public void setDateTime(DateTimeSyntax dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @param cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
