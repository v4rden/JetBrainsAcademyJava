import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.next().split("\\?");
        input = input[1].split("&");
        var pairs = new ArrayList<String>();
        for (var s : input) {
            var smth = s.split("=");
            pairs.add(smth[0]);
            if (smth.length > 1) {
                pairs.add(smth[1]);
            } else {
                pairs.add("not found");
            }
        }
        String[] fragments = pairs.toArray(new String[0]);
        String password = null;
        for (var i = 0; i < fragments.length; i += 2) {
            System.out.println(fragments[i] + " : " + fragments[i + 1]);
            if (fragments[i].equals("pass")) {
                password = fragments[i + 1];
            }
        }
        if (password != null) {
            System.out.println("password : " + password);
        }
    }
}