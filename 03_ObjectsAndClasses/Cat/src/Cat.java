
public class Cat
{
    private final int EYE_COUNT = 2;
    private final  double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;

    private static int count = 0;

    private double originWeight;
    private double weight;
    private Color color;



    private double foodAmount;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        foodAmount = 0;
        count++;

    }

    public Cat(double weight){
        this();
        this.weight = weight;
    }
// конструктор копирования
    public Cat(Cat cat){
        this.originWeight = cat.originWeight;
        this.weight = cat.weight;
        this.color = cat.color;
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
    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

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
    public void setWeight(double weight){
        this.weight = weight;
    }

    public static int getCount(){
        return count;
    }
    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            //count--;
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
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

    public void copyCat(Cat cat){
        this.originWeight = cat.originWeight;
        this.weight = cat.weight;
        this.color = cat.color;
    }
}