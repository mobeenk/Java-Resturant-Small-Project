
package resturant;

enum MealType {Rosebeef, grilled_Chiken, barbque_meat, salad}
public class Meal {
    private MealType type;
    private double price;

    public Meal(MealType type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Activity{" + "type=" + type + ", price=" + price + '}';
    }
    

    public MealType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    
}
