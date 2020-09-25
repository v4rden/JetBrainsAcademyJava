package converter;

public class Main {
    public static void main(String[] args) {

        System.out.println("10 is " + getBinary(10));
    }

    public static String getBinary(int dec){
        var cur = dec;
        var sb = new StringBuilder();
        while(cur > 0){
            var r = cur % 2 == 0 ? 0 : 1;
            sb.append(r);
            cur /= 2;
        }
        sb.append("b0");
        sb.reverse();
        return sb.toString();
    }
}
