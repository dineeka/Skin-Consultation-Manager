package w1867122;

public class Patient extends Person {
    private String patientId;

    public Patient(String pId){
        this.patientId = pId;
    }

    public String getPatientId(){
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
