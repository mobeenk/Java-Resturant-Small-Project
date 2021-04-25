
package resturant;


public class ReservationDetail {

    private Meal activityType;
    private int amount;

    public ReservationDetail(Meal activityType, int amount) {
        this.activityType = activityType;
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double getActivityTotal(){
        return this.activityType.getPrice()*this.amount;
    }
}
