// Press Shift twice to1 open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Codeopolis{
    public static void main (String[] args) {
        City city = new City ();
        //TextInterface textInterface = new TextInterface (city);
      //  textInterface.startGame ();
        city.hungersnot ();
        System.out.println("Bushels: " + city.getBushels());
        System.out.println("Starved: " + city.getStarved());
        System.out.println("Starved Percentage: " + city.getStarvedPercentage());


    }
}