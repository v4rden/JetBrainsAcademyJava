class Problem {

    public static void main(String[] args) {
        for (var i = 0; i < args.length; i += 2) {
            var param = args[i];
            var value = args[i + 1];
            System.out.println(
                    String.format("%s=%s", param, value));
        }
    }
}