package Lab3.model;


public class Human {
    private String firstName;
    private String lastName;
    private String surname;
    private Sex gender;

    public Human(String firstName, String lastName, String surname, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public Sex getGender() {
        return gender;
    }
}