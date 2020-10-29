
public class Loader
{
    public static void main(String[] args)
    {

        // TASK 1

//        Cat cat1 = new Cat();
//        Cat cat2 = new Cat();
//        Cat cat3 = new Cat();
//        Cat cat4 = new Cat();
//        Cat cat5 = new Cat();
//
//        System.out.println("Cat1: \n Status: " + cat1.getStatus() + "\n Weight: " + cat1.getWeight());
//        System.out.println("Cat2: \n Status: " + cat2.getStatus() + "\n Weight: " + cat2.getWeight());
//        System.out.println("Cat3: \n Status: " + cat3.getStatus() + "\n Weight: " + cat3.getWeight());
//        System.out.println("Cat4: \n Status: " + cat4.getStatus() + "\n Weight: " + cat4.getWeight());
//        System.out.println("Cat5: \n Status: " + cat5.getStatus() + "\n Weight: " + cat5.getWeight());
//
//
//        cat1.feed(21.);
//        cat2.feed((double) 100);
//        cat3.drink(100.);
//
//        System.out.println("Cat1: \n Status: " + cat1.getStatus() + "\n Weight: " + cat1.getWeight());
//        System.out.println("Cat2: \n Status: " + cat2.getStatus() + "\n Weight: " + cat2.getWeight());
//        System.out.println("Cat3: \n Status: " + cat3.getStatus() + "\n Weight: " + cat3.getWeight());
//
//
//        System.out.println("Let's kill cat1 :(");
//        while(cat1.getStatus() != "Exploded"){
//            cat1.feed(1000.);
//        }
//        System.out.println("Cat1: \n Status: " + cat1.getStatus() + "\n Weight: " + cat1.getWeight());
//
//        System.out.println("Let's make a deadly meow ");
//        while(cat2.getStatus() != "Dead"){
//            cat2.meow();
//        }
//        System.out.println("Cat2: \n Status: " + cat2.getStatus() + "\n Weight: " + cat2.getWeight());

        //TASK 2

//        Cat cat6 = new Cat();
//        System.out.println("Cat6: \n Weight: " + cat6.getWeight());
//        cat6.feed(100.);
//        cat6.feed(150.);
//        System.out.println("Cat6: \n Weight: " + cat6.getWeight());
//        cat6.pee();
//        cat6.pee();
//        System.out.println("Cat6: \n Weight: " + cat6.getWeight());
//        System.out.println("Cat ate: " + cat6.getFoodAmount() + "g");

        //TASK 3

        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        System.out.println(Cat.getCount());

        while(cat7.isAlive()){
            cat7.feed(1000.);
        }
        while(cat8.isAlive()){
            cat8.pee();
        }
        //System.out.println(cat7.getStatus());
        System.out.println(Cat.getCount());
        cat7.feed(100.);
        cat8.drink(100.);



    }
}