package correcter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        var scan = new Scanner(System.in);
        var input = scan.next();

        switch (input) {
            case "encode":
                encode();
                break;
            case "send":
                send();
                break;
            case "decode":
                decode();
                break;
        }
    }

    public static void decode() throws IOException {
        var errorBytes = readFile(RECEIVED);
        System.out.println("Received length:" + errorBytes.length);
        var p = new BytePrinter(errorBytes);
        System.out.println(p.getBin());

        var decoder = new Decoder(errorBytes);
        var result = decoder.get();
        System.out.println("Decoded length:" + result.length);

        p = new BytePrinter(result);
        System.out.println(p.getBin());
        System.out.println(p.getHex());
        writeToFile(result, DECODED);
    }

    public static void encode() throws IOException {
        var bytesToEncode = readFile(SEND);
        var p = new BytePrinter(bytesToEncode);
        System.out.println(p.getBin());

        var encoder = new Encoder(bytesToEncode);
        var result = encoder.get();

        p = new BytePrinter(result);
        System.out.println(p.getBin());
        System.out.println(p.getHex());
        writeToFile(result, ENCODED);
    }

    public static void send() throws IOException {
        var encodedBytes = readFile(ENCODED);

        makeErrorPerByte(encodedBytes);

        writeToFile(encodedBytes, RECEIVED);
    }

    public static void writeToFile(byte[] arr, String filePath) throws IOException {
        var writer = new FileOutputStream(filePath);
        writer.write(arr);
        writer.close();
    }

    public static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        var reader = new FileInputStream(file);
        byte[] content = new byte[(int) file.length()];
        reader.read(content, 0, (int) file.length());
        return content;
    }

    public static void makeErrorPerByte(byte[] arr) {
        var random = new Random();
        for (var i = 0; i < arr.length; i++) {
            var position = random.nextInt(8);
            arr[i] ^= 1 << position;
        }
    }

    public static final String SEND = "./send.txt";
    public static final String ENCODED = "./encoded.txt";
    public static final String RECEIVED = "./received.txt";
    public static final String DECODED = "./decoded.txt";

}

class Encoder {
    private final byte[] bytesToEncode;
    private final ArrayList<Byte> encodedBytes;

    public Encoder(byte[] bytes) {
        bytesToEncode = bytes;
        encodedBytes = new ArrayList<>();
        encode();
    }

    public byte[] get() {
        var r = new byte[encodedBytes.size()];
        for (var i = 0; i < encodedBytes.size(); i++) {
            r[i] = encodedBytes.get(i);
        }
        return r;
    }

    private void encode() {
        var sb = new StringBuilder();

        for (byte value : bytesToEncode) {
            sb.append(byteToString(value));
        }
        var charArray = sb.toString().toCharArray();
        var intArray = new int[charArray.length];
        for (var i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i += 4) {
            sb.append(intArray[i] ^ intArray[i + 1] ^ intArray[i + 3]);
            sb.append(intArray[i] ^ intArray[i + 2] ^ intArray[i + 3]);

            sb.append(intArray[i]);
            sb.append(intArray[i + 1] ^ intArray[i + 2] ^ intArray[i + 3]);

            sb.append(intArray[i + 1]);
            sb.append(intArray[i + 2]);

            sb.append(intArray[i + 3]);
            sb.append("0");
        }

        for (var st = 0; st < sb.length(); st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);

            encodedBytes.add((byte) (b & 0xff));
        }
    }

    private String byteToString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b))
                .replace(' ', '0');
    }
}

class Decoder {
    private final byte[] bytesToDecode;
    private final ArrayList<Byte> decodedBytes;

    public Decoder(byte[] bytes) {
        bytesToDecode = bytes;
        decodedBytes = new ArrayList<>();
        decode();
    }

    public byte[] get() {
        var r = new byte[decodedBytes.size()];
        for (var i = 0; i < decodedBytes.size(); i++) {
            r[i] = decodedBytes.get(i);
        }
        return r;
    }

    private void decode() {
        var sb = new StringBuilder();

        for (byte value : bytesToDecode) {
            sb.append(byteToString(value));
        }

        var charArray = sb.toString().toCharArray();
        var intArray = new int[charArray.length];
        for (var i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        sb = new StringBuilder();

        for (var i = 0; i < intArray.length; i += 8) {
            var p1IsCorrect = (intArray[i + 2] ^ intArray[i + 4] ^ intArray[i + 6]) == intArray[i];
            var p2IsCorrect = (intArray[i + 2] ^ intArray[i + 5] ^ intArray[i + 6]) == intArray[i];
            var p4IsCorrect = (intArray[i + 4] ^ intArray[i + 5] ^ intArray[i + 6]) == intArray[i];

            intArray[i + 2] = (!p1IsCorrect && !p2IsCorrect && p4IsCorrect) ? Math.abs(intArray[i + 2] - 1) : intArray[i + 2];
            intArray[i + 4] = (!p1IsCorrect && p2IsCorrect && !p4IsCorrect) ? Math.abs(intArray[i + 4] - 1) : intArray[i + 4];
            intArray[i + 5] = (p1IsCorrect && !p2IsCorrect && !p4IsCorrect) ? Math.abs(intArray[i + 5] - 1) : intArray[i + 5];
            intArray[i + 6] = (!p1IsCorrect && !p2IsCorrect && !p4IsCorrect) ? Math.abs(intArray[i + 6] - 1) : intArray[i + 6];

            sb.append(intArray[i + 2]);
            sb.append(intArray[i + 4]);
            sb.append(intArray[i + 5]);
            sb.append(intArray[i + 6]);
        }

        for (var st = 0; st < sb.length(); st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);

            decodedBytes.add((byte) (b & 0xff));
        }
    }

    private String byteToString(byte b) {
        var result = String.format("%8s", Integer.toBinaryString((byte) (b & 0xf)))
                .replace(' ', '0');
        return result;
    }
}

class BytePrinter {
    private final byte[] arr;

    BytePrinter(byte[] in) {
        arr = in;
    }

    public String getBin() {
        var sb = new StringBuilder();
        sb.append("bin view: ");
        for (var b : arr) {
            sb.append(String.format("%8s", Integer.toBinaryString((byte) (b & 0xf)))
                    .replace(' ', '0'));
            sb.append(" ");
        }
        return sb.toString();
    }

    public String getHex() {
        var sb = new StringBuilder();
        sb.append("hex view: ");
        for (byte b : arr) {
            String st = String.format("%02X", b);
            sb.append(st);
            sb.append(" ");
        }
        return sb.toString();
    }
}
