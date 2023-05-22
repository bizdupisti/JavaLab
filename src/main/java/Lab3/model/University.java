package Lab3.model;

public class University {
    private String universityName;
    private Human rector;

    public University(String universityName, Human rector) {
        this.universityName = universityName;
        this.rector = rector;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Human getRector() {
        return rector;
    }
}
