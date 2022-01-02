package domain;

public class Appointment implements Identifiable<Integer> {

    private String problem;
    public int Id;

    public Appointment() {
        this.Id = 0;
        this.problem = "";


    }

    public Appointment( int patientId, String problem) {

        this.problem = problem;
        this.Id = patientId;

    }
    public String getProblem() {
        return problem;
    }

    public int getPatientId() {
        return Id;
    }

    public void setPatientId(int patientId) {
        this.Id = patientId;
    }

    public void setproblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return " patientId " + Id + " problem: " + problem;
    }

    @Override
    public Integer getId() {
        return null;
    }
    @Override
    public void setId(Integer id) {

    }
}






