package machine;

public class CoffeeMachine {
    public static void main(String[] args) {

        System.out.println(Res.START);
        System.out.println(Res.GRINDING);
        System.out.println(Res.BOILING);
        System.out.println(Res.MIXING);
        System.out.println(Res.POURING_COFFEE);
        System.out.println(Res.POURING_MILK);
        System.out.println(Res.READY);
    }

    public static class Res {
        public static final String START = "Starting to make a coffee";
        public static final String GRINDING = "Grinding coffee beans";
        public static final String BOILING = "Boiling water";
        public static final String MIXING = "Mixing boiled water with crushed coffee beans";
        public static final String POURING_COFFEE = "Pouring coffee into the cup";
        public static final String POURING_MILK = "Pouring some milk into the cup";
        public static final String READY = "Coffee is ready!";
    }
}
