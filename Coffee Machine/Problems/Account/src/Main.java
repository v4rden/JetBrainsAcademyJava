class Account {
    long balance;
    String ownerName;
    Boolean locked;

    public Account(long balance, String ownerName, Boolean locked) {
        this.balance = balance;
        this.ownerName = ownerName;
        this.locked = locked;
    }
}