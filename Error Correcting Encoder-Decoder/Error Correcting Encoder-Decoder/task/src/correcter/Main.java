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

    //
    public static void decode() throws IOException {
        var r = readFile(RECEIVED);
        //var d = makeCodeGreatAgain(r);
        //writeToFile(d, DECODED);
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
        var e = readFile(ENCODED);
//        makeErrorPerByte(e);
        writeToFile(e, RECEIVED);
    }


    //
//    public static byte[] makeCodeGreatAgain(byte[] arr) {
//        if (arr.length % 3 != 0) System.out.println("Now what?");
//        var res = new byte[arr.length / 3];
//        var sb = new StringBuilder();
//
//        for (var i : arr) {
//            sb.append(Integer.toBinaryString(i).replace(' ', '0'));
//        }
//        var input = sb.toString();
//        restore(input, res);
//        return res;
//    }
//
//    public static void restore(String str, byte[] res) {
//        var sb = new StringBuilder();
//        int count = 0;
//        for (var i = 0; i < str.length() / 8; i += 8) {
//            var currentByte = str.substring(i, i + 8);
//            if (count < 7) {
//                var bb = new myByte(currentByte, false);
//                sb.append(bb.getString());
//                count++;
//            } else {
//                var bb = new myByte(currentByte, true);
//                sb.append(bb.getString());
//                count = 0;
//            }
//        }
//        sbToByteArr(sb, res);
//    }
//
//    public static byte[] encodeCorrectionBytes(byte[] arr) {
//        if (arr.length % 2 != 0) System.out.println("Now what?");
//        var res = new byte[arr.length * 3];
//        var sb = new StringBuilder();
//
//        for (var i = 0; i < arr.length; i += 2) {
//
//            var f = String.format("%8s", Integer.toBinaryString(arr[i]))
//                    .replace(' ', '0').toCharArray();
//            var s = String.format("%8s", Integer.toBinaryString(arr[i + 1]))
//                    .replace(' ', '0').toCharArray();
//
//            var fb = new myOtherByte();
//            fb.setFirst(f);
//            fb.setSecond(s);
//            sb.append(fb.getEncodedString());
//        }
//
//        sbToByteArr(sb, res);
//        return res;
//    }
//
//    public static void sbToByteArr(StringBuilder sb, byte[] arr) {
//        for (int i = 0, p = 0; i < arr.length; i++, p += 8) {
//            var sub = sb.substring(p, p + 8);
//            arr[i] = (byte) Integer.parseInt(sub, 2);
//        }
//    }
//
//    public static void appendToSb(char[] arr, StringBuilder sb) {
//        for (var i = 0; i < arr.length; i += 2) {
//            sb.append(arr[i]);
//            sb.append(arr[i]);
//            sb.append(arr[i + 1]);
//            sb.append(arr[i + 1]);
//            sb.append(arr[i + 2]);
//            sb.append(arr[i + 2]);
//
//            var check = (charToBool(arr[i]) ^ charToBool(arr[i + 1]) & charToBool(arr[i + 2]))
//                    ? 1 : 0;
//            sb.append(check);
//        }
//    }
//
//    public static boolean charToBool(char c) {
//        if (c == '1')
//            return true;
//        else
//            return false;
//    }
//
    public static void writeToFile(byte[] arr, String filePath) throws IOException {
        var writer = new FileOutputStream(filePath);
        writer.write(arr);
        writer.close();
    }

    public static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        return Files.readAllBytes(file.toPath());
    }

    //
//    public static void makeErrorPerByte(byte[] arr) {
//        var random = new Random();
//        for (var i = 0; i < arr.length; i++) {
//            var position = random.nextInt(8);
//            arr[i] ^= 1 << position;
//        }
//    }
//
//
    public static final String SEND = "./send.txt";
    public static final String ENCODED = "./encoded.txt";
    public static final String RECEIVED = "./received.txt";
    public static final String DECODED = "./decoded.txt";
//}
//
//class myByte {
//    private final int[] arr;
//    private final boolean isPadded;
//
//    myByte(String str, boolean isPadded) {
//        arr = new int[8];
//        this.isPadded = isPadded;
//        for (var i = 0; i < 8; i++) {
//            arr[i] = Character.getNumericValue(str.charAt(i));
//        }
//        correctSelf();
//    }
//
//    private void correctSelf() {
//        if (arr[6] != arr[7]) {
//            return;
//        }
//        if (arr[0] != arr[1]) {
//            arr[0] = arr[7] - arr[5] - arr[3];
//            arr[1] = arr[7] - arr[5] - arr[3];
//            return;
//        }
//        if (arr[2] != arr[3]) {
//            arr[2] = arr[7] - arr[5] - arr[1];
//            arr[3] = arr[7] - arr[5] - arr[1];
//            return;
//        }
//        if (arr[4] != arr[5]) {
//            arr[4] = arr[7] - arr[3] - arr[1];
//            arr[5] = arr[7] - arr[3] - arr[1];
//        }
//
//    }
//
//    public String getString() {
//        return (isPadded)
//                ? String.format("%d", arr[0])
//                : String.format("%d%d%d", arr[0], arr[2], arr[4]);
//    }
//}
//
//class myOtherByte {
//    private final int[] arr;
//
//    myOtherByte() {
//        arr = new int[2 * 8];
//    }
//
//    public void setFirst(char[] arr) {
//        for (var i = 0; i < arr.length; i++) {
//            this.arr[i] = Character.getNumericValue(arr[i]);
//        }
//    }
//
//    public void setSecond(char[] arr) {
//        for (var i = 8; i < arr.length; i++) {
//            this.arr[i] = Character.getNumericValue(arr[i]);
//        }
//    }
//
//    public String getEncodedString() {
//        var sb = new StringBuilder();
//        for (var i = 0; i < arr.length; i += 3) {
//            var check = 0;
//
//            sb.append(arr[i]);
//            sb.append(arr[i]);
//            if (i + 1 < arr.length) {
//                sb.append(arr[i + 1]);
//                sb.append(arr[i + 1]);
//                sb.append(arr[i + 2]);
//                sb.append(arr[i + 2]);
//
//                check = (intToBool(arr[i]) ^ intToBool(arr[i + 1]) ^ intToBool(arr[i + 2]))
//                        ? 1 : 0;
//            } else {
//                check = arr[i];
//            }
//            sb.append(check);
//            sb.append(check);
//        }
//
//        sb.insert(sb.length() - 2, "0000");
//        return sb.toString();
//    }
//
//    private static boolean intToBool(int i) {
//        if (i == 1)
//            return true;
//        else
//            return false;
//    }

}

class Encoder {
    private byte[] bytesToEncode;
    private int[] ints;
    private ArrayList<Byte> encodedbytes;

    public Encoder(byte[] bytes) {
        if (bytes.length % 2 != 0) {
            throw new IllegalArgumentException("Encoded Array should be even");
        }
        bytesToEncode = bytes;
        encodedbytes = new ArrayList<>();
        encode();
    }

    public byte[] get() {
        var r = new byte[encodedbytes.size()];
        for (var i = 0; i < encodedbytes.size(); i++) {
            r[i] = encodedbytes.get(i);
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

            encodedbytes.add((byte) (b & 0xff));
        }

        if (bytesToEncode.length * 3 != encodedbytes.size()) {
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

class EncodingDoubleByte {
    private final int[] arr;

    EncodingDoubleByte(char[] in) {
        arr = new int[in.length];

        for (int i = 0; i < in.length; i++) {
            arr[i] = Character.getNumericValue(in[i]);
        }
    }

    public byte[] getEncoded() {
        var sb = new StringBuilder();

//        for (int i = 0; i < arr.length; i += 3) {
//            sb.append(arr[i]);
//            sb.append(arr[i]);
//            if (i + 1 < arr.length) {
//                sb.append(arr[i + 1]);
//                sb.append(arr[i + 1]);
//                sb.append(arr[i + 2]);
//                sb.append(arr[i + 2]);
//                sb.append(checkSum(arr[i], arr[i + 1], arr[i + 2]));
//                sb.append(checkSum(arr[i], arr[i + 1], arr[i + 2]));
//            } else {
//                sb.append("0000");
//                sb.append(checkSum(arr[i], 0, 0));
//                sb.append(checkSum(arr[i], 0, 0));
//            }
//        }

        if (sb.length() != 6 * 8) {
            throw new RuntimeException("Encoding failed");
        }

        var sixBytes = new byte[6];

        for (int i = 0, st = 0; i < sixBytes.length; i++, st += 8) {
            var sub = sb.substring(st, st + 8);
            var b = (byte) Integer.parseInt(sub, 2);
            sixBytes[i] = (byte) (b & 0xff);
        }
        return sixBytes;
    }

    public int checkSum(int a, int b, int c) {
        return a ^ b ^ c;
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
//            sb.append(b);
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
