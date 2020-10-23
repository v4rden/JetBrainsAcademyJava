class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        var arr = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            arr[i - 1] = Integer.parseInt(args[i]);
        }
        switch (operator) {
            case "MAX":
                System.out.println(max(arr));
                break;
            case "MIN":
                System.out.println(min(arr));
                break;
            case "SUM":
                System.out.println(sum(arr));
                break;
        }
    }

    public static int max(int[] arr) {
        var result = 0;
        for (int j : arr) {
            if (j > result) {
                result = j;
            }
        }
        return result;
    }

    public static int min(int[] arr) {
        var result = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < result) {
                result = j;
            }
        }
        return result;
    }

    public static int sum(int[] arr) {
        var result = 0;
        for (var e : arr) {
            result += e;
        }
        return result;
    }
}