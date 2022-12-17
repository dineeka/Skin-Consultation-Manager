package w1867122;

import javax.print.attribute.DateTimeSyntax;

public class Consultation {
    private Doctor doctor;
    private Patient patient;
    private DateTimeSyntax dateTime;
    private int cost;
    private String notes;

    public Consultation(){}

    /**
     * @param dateTime
     * @param price
     * @param notes
     * @param
     */
    public Consultation(Doctor doctor, Patient patient, DateTimeSyntax dateTime, int price, String notes){
        this.doctor = doctor;
        this.patient = patient;
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

    @Override
    public String toString() {
        return "Consultation{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", dateTime=" + dateTime +
                ", cost=" + cost +
                ", notes='" + notes + '\'' +
                '}';
    }

}
