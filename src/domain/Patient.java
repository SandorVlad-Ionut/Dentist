package domain;

public class Patient implements Identifiable<Integer>  {
    private int ID;
    private int age;
    private String name;

    public Patient() {
        this.ID = 0;
        this.name = "";
        this.age = 0;

    }

    public Patient(int id, String name, int age) {
        this.ID = id;
        this.name = name;
        this.age = age;

    }

    public String toString() {
        return "Patient " + this.name +
                " ID: " + this.ID +
                " age: " + this.age;
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return ID;
    }

    @Override
    public void setId(Integer id) {

    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public void setId(int i) {
        this.ID = i;
    }

}