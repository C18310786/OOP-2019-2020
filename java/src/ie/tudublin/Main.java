package ie.tudublin;

public class Main
{
    public static void main(String[] arg)
    {
        System.out.println("Hello world!");

        Animal misty = new Dog(); // Polymorphism

        misty.setName("Misty");
        System.out.println(misty.getName());
        misty.speak();

        Cat topcat = new Cat();
        topcat.speak();

        System.out.println(topcat.getNumLives());
        while(topcat.getNumLives() > 0)
        {
            topcat.kill();
            System.out.println(topcat.getNumLives());
        }
        if(topcat.getNumLives() == 0)
        {
            System.out.println("Dead");
        }
    }
}
