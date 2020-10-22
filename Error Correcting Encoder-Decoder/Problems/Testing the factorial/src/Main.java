public long get(int x) {
    long result = 1;
        if (x < 0) {
        return (long) -1;
        }
        for (var i = x; i > 0; i--) {
            result *= i;
        }
        return result;
}