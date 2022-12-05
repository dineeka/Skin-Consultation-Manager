public class Doctor extends Person{

    private String medLicenceNumber, specialisation;

    public Doctor(){
        medLicenceNumber = this.medLicenceNumber;
        specialisation = this.specialisation;
    }

    public String getMedLicenceNumber() {
        return medLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setMedLicenceNumber(String medLicenceNumber) {
        this.medLicenceNumber = medLicenceNumber;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
