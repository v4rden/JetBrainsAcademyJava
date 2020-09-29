class Account {

    private long balance;
    private String ownerName;
    private boolean locked;

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setOwnerName(String name) {
        this.ownerName = name;
    }

    public void setLocked(boolean isLocked) {
        this.locked = isLocked;
    }

    public long getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public boolean isLocked() {
        return locked;
    }
}