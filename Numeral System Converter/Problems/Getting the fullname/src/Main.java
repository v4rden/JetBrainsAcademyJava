class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        var emptyFirst = firstName.length() == 0;
        var emptyLast = lastName.length() == 0;

        if (emptyFirst && emptyLast) {
            return "Unknown";
        }

        if (emptyFirst) {
            return lastName;
        }

        if (emptyLast) {
            return firstName;
        }

        return firstName + " " + lastName;
    }
}