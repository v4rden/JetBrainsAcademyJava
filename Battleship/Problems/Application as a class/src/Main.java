class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        for (var s : args) {
            System.out.println(s);
        }
    }
}