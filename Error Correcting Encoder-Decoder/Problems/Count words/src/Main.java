import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        var c = reader.read();
        var previous = ' ';
        while (c != -1) {
            if (c != ' ') {
                sb.append((char) c);
            } else {
                if (previous != ' ')
                    sb.append((char) c);
            }
            previous = (char) c;
            c = reader.read();
        }
        reader.close();
        var res = sb.toString().trim();

        if (res.length() <= 1 || res.equals(" ")) {
            System.out.println(0);
        } else {

            int lastIndex = 0;
            int count = 0;

            while (lastIndex != -1) {

                lastIndex = res.indexOf(" ", lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += 1;
                }
            }
            System.out.println(count + 1);
        }
    }
}