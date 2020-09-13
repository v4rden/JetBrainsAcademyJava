class Patient {

    String name;

    public void say() {
        System.out.print(String.format(
                "Hello, my name is %s, I need a doctor.", name));
    }
}