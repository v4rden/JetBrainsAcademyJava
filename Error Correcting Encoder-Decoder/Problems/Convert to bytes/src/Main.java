import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        var bytes = inputStream.readAllBytes();
        for (var i : bytes) {
            System.out.print(i);
        }
    }
}