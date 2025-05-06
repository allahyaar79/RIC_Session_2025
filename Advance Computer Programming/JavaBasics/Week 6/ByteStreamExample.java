//read the binary data from the file and create its output
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteStreamExample {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("input.bin");
        FileOutputStream out = new FileOutputStream("output.bin");
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        in.close();
        out.close();
    }
}
