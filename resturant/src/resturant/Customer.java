
package resturant;

import java.util.ArrayList;



public class Customer extends Person {
    private double balance;
    private ArrayList<Reservation> reservations;

    public Customer(){}


    public Customer( String fullname, Date dob, String address,
    double balance ) {
        super(fullname, dob, address);
        this.balance = balance;
        this.reservations = new ArrayList<Reservation>();
      
    }
       public Customer(ArrayList<Reservation> reservations, String fullname, Date dob, String address,
    double balance) {
        super(fullname, dob, address);
        this.balance = balance;
        this.reservations = reservations;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }



    public void payReservation(int serialNo){
        for(Reservation r: reservations){
            if(r.getSerialNo() == serialNo){
                double amount = r.getReservationAmount();
                this.balance -= amount;
            }
            else if(r.getSerialNo() != serialNo){
                System.out.println("Reservation was not found!");
            }
        }
    }
    public void reserve(Reservation r){
        this.reservations.add(r);
    }

    @Override
    public String toString() {
        return super.toString()+" balance=" + balance;
    }
    
    
    
}
