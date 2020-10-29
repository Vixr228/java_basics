
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();

        System.out.println("Cat1: \n Status: " + cat1.getStatus() + "\n Weight: " + cat1.getWeight());
        System.out.println("Cat2: \n Status: " + cat2.getStatus() + "\n Weight: " + cat2.getWeight());
        System.out.println("Cat3: \n Status: " + cat3.getStatus() + "\n Weight: " + cat3.getWeight());
        System.out.println("Cat4: \n Status: " + cat4.getStatus() + "\n Weight: " + cat4.getWeight());
        System.out.println("Cat5: \n Status: " + cat5.getStatus() + "\n Weight: " + cat5.getWeight());


        cat1.feed(21.);
        cat2.feed((double) 100);
        cat3.drink(100.);

        System.out.println("Cat1: \n Status: " + cat1.getStatus() + "\n Weight: " + cat1.getWeight());
        System.out.println("Cat2: \n Status: " + cat2.getStatus() + "\n Weight: " + cat2.getWeight());
        System.out.println("Cat3: \n Status: " + cat3.getStatus() + "\n Weight: " + cat3.getWeight());


        System.out.println("Let's kill cat1 :(");
        while(cat1.getStatus() != "Exploded"){
            cat1.feed(1000.);
        }
        System.out.println("Cat1: \n Status: " + cat1.getStatus() + "\n Weight: " + cat1.getWeight());

        System.out.println("Let's make a deadly meow ");
        while(cat2.getStatus() != "Dead"){
            cat2.meow();
        }
        System.out.println("Cat2: \n Status: " + cat2.getStatus() + "\n Weight: " + cat2.getWeight());


    }
}