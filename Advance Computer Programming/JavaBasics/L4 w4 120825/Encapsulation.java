class Student {
    private String name; // private variable

    // Public getter and setter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Student {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Ali");
        System.out.println("Student Name: " + s.getName());
    }
}
