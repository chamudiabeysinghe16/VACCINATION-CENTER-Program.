package model2;
public class Booth {
    private String patientName;
    private int boothNum;
    private String vaccinationType;
    private boolean empty;
    private int noOfBooths;
    private String surname;
    private int age;
    private String city;
    private long NIC;

    public Booth(String patientName) {
        this.setPatientName(patientName);
        this.setBoothNum(getBoothNum());
        this.setVaccinationType(getVaccinationType());
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getBoothNum() {
        return boothNum;
    }

    public void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }

    public void setVaccinationType(String vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public int getNoOfBooths() {
        return noOfBooths;
    }

    public void setNoOfBooths(int noOfBooths) {
        this.noOfBooths = noOfBooths;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public long getNIC() { return NIC; }

    public void setNIC(long NIC) { this.NIC = NIC; }
}

