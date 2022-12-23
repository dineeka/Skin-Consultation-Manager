package w1867122;

import java.time.LocalDateTime;

public class Consultation {
    private int licenseNum;
    private Patient patient;
    private LocalDateTime dateTime;
    private int cost;
    private String notes;

    public Consultation(){}

    /**
     * @param dateTime
     * @param price
     * @param notes
     * @param
     */
    public Consultation(int licenseNum, Patient patient, LocalDateTime dateTime, int price, String notes){
        this.licenseNum = licenseNum;
        this.patient = patient;
        this.dateTime = dateTime;
        this.cost = price;
        this.notes = notes;
    }

    public int getLicenseNum() {
        return licenseNum;
    }

    /**
     * @return
     */
    public LocalDateTime getDateTime() {
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

    public void setLicenseNum(int licenseNum) {
        this.licenseNum = licenseNum;
    }

    /**
     * @param dateTime
     */
    public void setDateTime(LocalDateTime dateTime) {
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
                "DoctorLicenseNumber=" + licenseNum +
                ", patient=" + patient +
                ", dateTime=" + dateTime +
                ", cost=" + cost +
                ", notes='" + notes + '\'' +
                '}';
    }

}
