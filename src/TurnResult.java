import java.util.Objects;

/**
 * The `TurnResult` class represents the result of a game
 * turn.
 * It encapsulates various information about the state of
 * the game after a turn.
 */
public class TurnResult {

    private int acres; // Current number of acres owned
    // by the city
    private int ateByRates; // Number of bushels eaten by
    // rats during the turn
    private int bushels; // Current number of bushels in
    // the city
    private int bushelsHarvested; // Amount of bushels
    // harvested during the turn
    private String name; // The name of the city
    private int newResidents; // Number of new residents
    // in the city after the turn
    private int residents; // Current number of residents
    // in the city
    private int starved; // Number of residents who
    // starved during the turn
    private int starvedPercentage; // Percentage of
    // residents starved during the turn
    private int year; // The year of the city

    /**
     * Constructs a `TurnResult` object with the
     * specified values for each
     * attribute.
     *
     * @param name              The name of the city
     * @param year              The year of the city
     * @param newResidents      Number of new residents
     *                          in the city after the turn
     * @param bushelsHarvested  Amount of bushels
     *                          harvested during the turn
     * @param residents         Current number of
     *                          residents in the city
     * @param bushels           Current number of bushels
     *                          in the city
     * @param starved           Number of residents who
     *                          starved during the turn
     * @param acres             Current number of acres
     *                          owned by the city
     * @param ateByRates        Number of bushels eaten
     *                          by rats during the turn
     * @param starvedPercentage Percentage of starved
     *                          residents
     */
    public TurnResult(String name, int year, int newResidents, int bushelsHarvested, int residents, int bushels, int starved, int acres, int ateByRates, int starvedPercentage) {
        this.name = name;
        this.year = year;
        this.newResidents = newResidents;
        this.bushelsHarvested = bushelsHarvested;
        this.residents = residents;
        this.bushels = bushels;
        this.starved = starved;
        this.acres = acres;
        this.ateByRates = ateByRates;
        this.starvedPercentage = starvedPercentage;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof TurnResult)) {
            return false;
        }
        TurnResult that = (TurnResult) object;
        return year == that.year && newResidents == that.newResidents && bushelsHarvested == that.bushelsHarvested &&
               residents == that.residents && bushels == that.bushels && starved == that.starved &&
               acres == that.acres && ateByRates == that.ateByRates && starvedPercentage == that.starvedPercentage &&
               Objects.equals(name, that.name);
    }

    /**
     * Returns the current number of acres in the city.
     *
     * @return The number of acres
     */
    public int getAcres() {
        return acres;
    }

    /**
     * Returns the number of bushels eaten by rats during
     * the turn.
     *
     * @return The number of bushels eaten by rats
     */
    public int getAteByRates() {
        return ateByRates;
    }

    /**
     * Returns the current number of bushels in the city.
     *
     * @return The number of bushels
     */
    public int getBushels() {
        return bushels;
    }

    /**
     * Returns the amount of bushels harvested during the
     * turn.
     *
     * @return The amount of bushels harvested
     */

    public int getBushelsHarvested() {
        return bushelsHarvested;
    }

    /**
     * Returns the name of the city.
     *
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of new residents in the city
     * after the turn.
     *
     * @return The number of new residents
     */
    public int getNewResidents() {
        return newResidents;
    }

    /**
     * Returns the current number of residents in the city.
     *
     * @return The number of residents
     */
    public int getResidents() {
        return residents;
    }

    /**
     * Returns the number of residents who starved during
     * the turn.
     *
     * @return The number of starved residents
     */
    public int getStarved() {
        return starved;
    }

    /**
     * Returns the percentage of residents starved during
     * this turn.
     *
     * @return Percentage of residents starved during
     * this turn.
     */
    public int getStarvedPercentage() {
        return starvedPercentage;
    }

    /**
     * Returns the year of the city.
     *
     * @return The year of the city.
     */
    public int getYear() {
        return year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, year, newResidents, bushelsHarvested, residents, bushels, starved,
                acres, ateByRates, starvedPercentage);
    }

    @Override
    public String toString() {


        return "TurnResult:\n" +

               "name = " + name + ", year = " + year + ", " + "newResidents = " + newResidents + ",\n" +

               "bushelsHarvested = " + bushelsHarvested + ", " + "residents = " + residents + ", bushels = " + bushels +
               ",\n" +

               "starved = " + starved + ", acres = " + acres + ", ateByRates = " + ateByRates + ", " +
               "starvedPercentage = " + starvedPercentage + "\n";

    }


}
