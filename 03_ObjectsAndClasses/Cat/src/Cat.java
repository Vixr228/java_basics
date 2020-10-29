
public class Cat
{
    private static int count = 0;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodAmount;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        foodAmount = 0;
        count++;

    }

    public boolean isAlive(){
        //if(weight < minWeight || weight > maxWeight) return false;
        if(this.getStatus() == "Dead" || this.getStatus() == "Exploded") {
            count--;
            return false;
        }
        else return true;
    }
    public void meow()
    {
        if(isAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
        }
        else System.out.println("Cat is dead");

    }

    /** Создайте в классе Cat метод, который возвращает сумму съеденной еды текущей кошки. */

    public double getFoodAmount(){
        return foodAmount;
    }
    /** Создайте в классе Cat метод «Сходить в туалет» pee(), который уменьшает вес кошки и что-нибудь печатает. */

    public void pee(){
        if(isAlive()) {
            weight -= 100;
            System.out.println("Congratulations!");
        }
        else System.out.println("Cat is dead");
    }

    public void feed(Double amount)
    {
        if(isAlive()) {
            weight = weight + amount;
            foodAmount += amount;
        }
        else System.out.println("Cat is dead");
    }

    public void drink(Double amount)
    {
        if(isAlive()) {
            weight = weight + amount;
        }
        else System.out.println("Cat is dead");

    }

    public Double getWeight()
    {
        return weight;
    }

    public static int getCount(){
        return count;
    }
    public String getStatus()
    {
        if(weight < minWeight) {
            //count--;
            return "Dead";
        }
        else if(weight > maxWeight) {
            //count--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}