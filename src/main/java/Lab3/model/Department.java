package Lab3.model;


public class Department {
    private String name;
    private Human leader;

    public Department(String name, Human leader) {
        this.name = name;
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public Human getLeader() {
        return leader;
    }
}
