package correcter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
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
        var p = new BytePrinter(errorBytes);
        System.out.println(p.getBin());

        var decoder = new Decoder(errorBytes);
        var result = decoder.get();

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
        return Files.readAllBytes(file.toPath());
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
    private byte[] bytesToEncode;
    private final ArrayList<Byte> encodedBytes;

    public Encoder(byte[] bytes) {
        if (bytes.length % 2 != 0) {
            //throw new IllegalArgumentException("Encoded Array should be even");
        }
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
        for (var i = 0; i < bytesToEncode.length; i++) {
            sb.append(byteToString(bytesToEncode[i]));
        }
        var charArray = sb.toString().toCharArray();
        var intArray = new int[charArray.length];
        for (var i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i += 3) {
            sb.append(intArray[i]);
            sb.append(intArray[i]);
            if (i + 1 < intArray.length) {
                sb.append(intArray[i + 1]);
                sb.append(intArray[i + 1]);
                sb.append(intArray[i + 2]);
                sb.append(intArray[i + 2]);
                sb.append(checkSum(intArray[i], intArray[i + 1], intArray[i + 2]));
                sb.append(checkSum(intArray[i], intArray[i + 1], intArray[i + 2]));
            } else {
                sb.append("0000");
                sb.append(checkSum(intArray[i], 0, 0));
                sb.append(checkSum(intArray[i], 0, 0));
            }
        }

        for (var st = 0; st < sb.length(); st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);

            encodedBytes.add((byte) (b & 0xff));
        }

        if (bytesToEncode.length * 3 != encodedBytes.size()) {
            //throw new RuntimeException("Should be three times larger");
        }

    }

    private int checkSum(int a, int b, int c) {
        return a ^ b ^ c;
    }

    private String byteToString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b))
                .replace(' ', '0');
    }
}

class Decoder {
    private byte[] bytesToDecode;
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
        for (var i = 0; i < bytesToDecode.length; i++) {
            sb.append(byteToString(bytesToDecode[i]));
        }
        var charArray = sb.toString().toCharArray();
        var intArray = new int[charArray.length];
        for (var i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        sb = new StringBuilder();

        for (var i = 0; i < intArray.length; i += 8) {
            if (i + 1 == intArray.length) {
                if (intArray[6 + i] != intArray[7 + i]) {
                    sb.append(intArray[0 + i]);
                } else {
                    sb.append(intArray[7 + i]);
                }
                continue;
            }


            if (intArray[6 + i] != intArray[7 + i]) {
                sb.append(intArray[0 + i]);
                sb.append(intArray[2 + i]);
                sb.append(intArray[4 + i]);
            }
            if (intArray[0 + i] != intArray[1 + i]) {
                sb.append(calculateFromChecksum(intArray[6 + i], intArray[2 + i], intArray[4 + i]));
                sb.append(intArray[2 + i]);
                sb.append(intArray[4 + i]);
            }
            if (intArray[2 + i] != intArray[3 + i]) {
                sb.append(intArray[0 + i]);
                sb.append(calculateFromChecksum(intArray[6 + i], intArray[0 + i], intArray[4 + i]));
                sb.append(intArray[4 + i]);
            }
            if (intArray[4 + i] != intArray[5 + i]) {
                sb.append(intArray[0 + i]);
                sb.append(intArray[2 + i]);
                sb.append(calculateFromChecksum(intArray[6 + i], intArray[0 + i], intArray[2 + i]));
            }
        }


        for (var st = 0; st < sb.length(); st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);

            decodedBytes.add((byte) (b & 0xff));
        }
    }

    private int calculateFromChecksum(int sum, int a, int b) {
        return sum ^ a ^ b;
    }

    private String byteToString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b))
                .replace(' ', '0');
    }
}

class BytePrinter {
    private byte[] arr;

    BytePrinter(byte[] in) {
        arr = in;
    }

    public String getBin() {
        var sb = new StringBuilder();
        sb.append("bin view: ");
        for (var b : arr) {
            sb.append(String.format("%8s", Integer.toBinaryString((byte) b & 0xff))
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
