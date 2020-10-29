
public class Cat
{
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

    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    /** Создайте в классе Cat метод, который возвращает сумму съеденной еды текущей кошки. */

    public double getFoodAmount(){
        return foodAmount;
    }
    /** Создайте в классе Cat метод «Сходить в туалет» pee(), который уменьшает вес кошки и что-нибудь печатает. */

    public void pee(){
        weight -= 100;
        System.out.println("Congratulations!");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        foodAmount += amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
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