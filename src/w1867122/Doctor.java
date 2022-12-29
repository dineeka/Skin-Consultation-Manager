package w1867122;


import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Person implements Serializable{

    private String specialisation;
    private int medLicenceNumber;


    public Doctor(){
    }

    public Doctor(String name, String surname, LocalDate dateOfBirth, int mobileNumber, int Lnum, String spec){
        super(name,surname,dateOfBirth,mobileNumber);
        this.specialisation = spec;
        this.medLicenceNumber = Lnum;
    }

    public int getMedLicenceNumber() {
        return medLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setMedLicenceNumber(int medLicenceNumber) {
        this.medLicenceNumber = medLicenceNumber;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String toString(){
        return (
                "\nDoctor's Name            : " + getName() +
                        "\nDoctor's Surname          : " + getSurname() +
                "\nDoctor's Date of Birth : " + getDateOfBirth() +
                "\nDoctor's Mobile Number : " + getMobileNumber() +
                "\nDoctor's License Number : " + getMedLicenceNumber() +
                "\nDoctor's Specialisation : " + getSpecialisation() + "\n");
    }

}
