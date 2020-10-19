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
        var p = new BytePrinter(errorBytes);
        System.out.println(p.getBin());
        System.out.println(p.getHex());

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
        System.out.println(p.getHex());

        var encoder = new Encoder(bytesToEncode);
        var result = encoder.get();

        p = new BytePrinter(result);
        System.out.println(p.getBin());
        System.out.println(p.getHex());
        writeToFile(result, ENCODED);
    }

    public static void send() throws IOException {
        var encodedBytes = readFile(ENCODED);
        var p = new BytePrinter(encodedBytes);
        System.out.println(p.getBin());
        System.out.println(p.getHex());

        //makeErrorPerByte(encodedBytes);
        var sender = new Sender(encodedBytes);
        var errors = sender.get();

        p = new BytePrinter(errors);
        System.out.println(p.getBin());
        System.out.println(p.getHex());
        writeToFile(errors, RECEIVED);
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
            sb.append(Helper.byteToString(value));
        }
        var charArray = sb.toString().toCharArray();
        var intArray = new int[charArray.length];
        for (var i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i += 4) {
            var first = intArray[i];
            var second = intArray[i + 1];
            var third = intArray[i + 2];
            var forth = intArray[i + 3];

            sb.append(first ^ second ^ forth);  //0
            sb.append(first ^ third ^ forth);   //1
            sb.append(first);                   //2
            sb.append(second ^ third ^ forth);  //3

            sb.append(second);                  //4
            sb.append(third);                   //5
            sb.append(forth);                   //6
            sb.append("0");                     //7
        }

        for (var st = 0; st < sb.length(); st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);

            encodedBytes.add((byte) (b & 0xff));
        }
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
            sb.append(Helper.byteToString(value));
        }

        var charArray = sb.toString().toCharArray();
        var intArray = new int[charArray.length];
        for (var i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        sb = new StringBuilder();

        for (var i = 0; i < intArray.length; i += 8) {
            int zeroParity = intArray[i];
            int oneParity = intArray[i + 1];
            int twoV = intArray[i + 2];
            int threeParity = intArray[i + 3];
            int fourV = intArray[i + 4];
            int fiveV = intArray[i + 5];
            int sixV = intArray[i + 6];
            int sevenV = intArray[i + 7];  //not used

            var p1IsCorrect = (twoV ^ fourV ^ sixV) == zeroParity;
            var p2IsCorrect = (twoV ^ fiveV ^ sixV) == oneParity;
            var p4IsCorrect = (fourV ^ fiveV ^ sixV) == threeParity;

            var needToCorrectFirstBit = !p1IsCorrect && !p2IsCorrect && p4IsCorrect;
            var needToCorrectSecondBit = !p1IsCorrect && p2IsCorrect && !p4IsCorrect;
            var needToCorrectThirdBit = p1IsCorrect && !p2IsCorrect && !p4IsCorrect;
            var needToCorrectForthBit = !p1IsCorrect && !p2IsCorrect && !p4IsCorrect;

            twoV = (needToCorrectFirstBit) ? Math.abs(intArray[i + 2] - 1) : intArray[i + 2];
            fourV = (needToCorrectSecondBit) ? Math.abs(intArray[i + 4] - 1) : intArray[i + 4];
            fiveV = (needToCorrectThirdBit) ? Math.abs(intArray[i + 5] - 1) : intArray[i + 5];
            sixV = (needToCorrectForthBit) ? Math.abs(intArray[i + 6] - 1) : intArray[i + 6];

            sb.append(twoV);
            sb.append(fourV);
            sb.append(fiveV);
            sb.append(sixV);
        }

        for (var st = 0; st < sb.length(); st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);

            decodedBytes.add(b);
            //decodedBytes.add((byte) (b & 0xff));
        }
    }
}

class Sender {
    private final byte[] bytesToEncode;
    private final ArrayList<Byte> encodedBytes;

    public Sender(byte[] bytes) {
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
            sb.append(Helper.byteToString(value));
        }
        var charArray = sb.toString().toCharArray();
        var intArray = new int[charArray.length];
        for (var i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }
        var random = new Random();
        sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i += 8) {
            var r = random.nextInt(8);
            var index = 0;
            for (var j = i; j < i + 8; j++) {
                if (index == r) {
                    sb.append(intArray[j] == 0 ? 1 : 0);
                } else {
                    sb.append(intArray[j]);
                }
                index++;
            }
        }

        for (var st = 0; st < sb.length(); st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);

            encodedBytes.add((byte) (b & 0xff));
        }
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
            var unsign = (byte) (b & 0xf);
            sb.append(Helper.byteToString(unsign));
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

class Helper {
    public static String byteToString(byte input) {

        var formatted = String.format("%8s", Integer.toBinaryString(input & 0xff))
                .replace(' ', '0');

        return formatted;
    }
}
