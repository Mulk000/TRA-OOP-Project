package Interface;

public interface Billable {
    double calculateCharges();
    String generateBill();
    void processPayment(double amount);
}