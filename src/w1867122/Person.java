package w1867122;

public class Person {
    private String name, surname, dateOfBirth;
    private int mobileNumber;

    public Person(String name, String surname, String dateOfBirth, int mobileNumber){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
