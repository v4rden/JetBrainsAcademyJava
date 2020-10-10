import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        var writer = new CharArrayWriter();

        for (var i : words) {
            writer.write(i);
        }

        return writer.toCharArray();
    }
}