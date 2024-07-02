public class Customer {
    private int atmNumber;
    private int pin;

    public Customer(int atmNumber, int pin) {
        this.atmNumber = atmNumber;
        this.pin = pin;
    }

    public int getAtmNumber() {
        return atmNumber;
    }

    public int getPin() {
        return pin;
    }
}
