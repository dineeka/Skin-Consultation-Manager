package w1867122;

import java.time.LocalDate;

public class Patient extends Person {
    private String patientId;

    public Patient(){
    }

    public Patient(String name, String surname, LocalDate dateOfBirth, int mobileNumber, String pId){
        super(name, surname, dateOfBirth, mobileNumber);
        this.patientId = pId;
    }


    public String getPatientId(){
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String toString() {
        return "Patient{" +
                 "\nPatient Name: "+ getName()+
                 "\nPatient surname: " + getSurname() +
                "\nPatient Date of Birth: " + getDateOfBirth()+
                "\nPatient Mobile Number: " + getMobileNumber()+
                "\nPatient ID: "+ getPatientId()+
                '}';
    }
}
