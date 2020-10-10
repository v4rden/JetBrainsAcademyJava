import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var c = reader.read();
        while (c != -1) {
            sb.append((char) c);
            c = reader.read();
        }

        reader.close();
        System.out.println(sb.reverse().toString());
    }
}