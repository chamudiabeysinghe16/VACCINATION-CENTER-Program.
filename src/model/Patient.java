package model;
public class Patient {

        public static String firstname;
        private String surname;
        private int age;
        private String city;
        private long NIC;
        private String vaccinationRequested;


        public Patient(String firstname, String surname, int age, String city, long NIC, String vaccinationRequested){
            this.setFirstname(firstname);
            this.setSurname(surname);
            this.setAge(age);
            this.setCity(city);
            this.setNIC(NIC);
            this.setVaccinationRequested(vaccinationRequested);

        }


    public static String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getNIC() {
        return NIC;
    }

    public void setNIC(long NIC) {
        this.NIC = NIC;
    }

    public String getVaccinationRequested() {
        return vaccinationRequested;
    }

    public void setVaccinationRequested(String vaccinationRequested) {
        this.vaccinationRequested = vaccinationRequested;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

