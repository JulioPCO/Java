package Collections;

public class Customer implements Comparable<Customer>{
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Customer other) {
        // TODO Auto-generated method stub
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
