public class Game{
    private City city;
    private TextInterface textInterface;
    private TurnResult tureResult;

    public Game (City city, TextInterface textInterface) {
        this.city = city;
        this.textInterface = textInterface;
    }

    public void playGame () {
        for (int year = 1; year <= 10; year++) {

            textInterface.gameLoop ();

            System.out.println (city.runTurn ().toString ());
        }
    }
}
