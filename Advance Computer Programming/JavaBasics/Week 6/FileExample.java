//is  file exists or not
import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("example.text");
        if (file.exists()) {
            System.out.println("File exists: " + file.getName());
        } else {
            System.out.println("File does not exist.");
        }
    }
}
