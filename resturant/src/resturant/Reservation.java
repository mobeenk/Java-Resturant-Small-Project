
package resturant;

import java.util.ArrayList;

enum Status {paid, unpaid}

public class Reservation {
    private int serialNo;
    private Date dateApplied ;
    private Status status;
    private ArrayList<ReservationDetail> reservations;

     public Reservation(int serialNo, Date dateApplied, Status status) {
        this.serialNo = serialNo;
        this.dateApplied = dateApplied;
        this.status = status;
        this.reservations = new ArrayList<ReservationDetail>() ;
    }
     
    public Reservation(int serialNo, Date dateApplied, Status status, ArrayList<ReservationDetail> reservations) {
        this.serialNo = serialNo;
        this.dateApplied = dateApplied;
        this.status = status;
        this.reservations = reservations;
    }

    Reservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<ReservationDetail> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<ReservationDetail> reservations) {
        this.reservations = reservations;
    }
    public void addDetail(ReservationDetail rd){
        this.reservations.add(rd);
        
    }
    
     public double getReservationAmount(){
        double total = 0;
        for(ReservationDetail r: reservations){
           total += r.getActivityTotal();
           return total;
        }
     
        return 0;
    }
}
