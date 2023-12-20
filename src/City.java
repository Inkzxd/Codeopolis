import java.util.Random;

public class City{

    private int acres; // Current number of acres owned by the city
    private int ateByRates; // Number of bushels eaten by rats during the turn
    private int bushels; // Current number of bushels in the city
    private int bushelsHarvested; // Amount of bushels harvested during the turn
    private String name; // The name of the city
    private int newResidents; // Number of new residents in the city after the turn
    private int residents; // Current number of residents in the city
    private int starved; // Number of residents who starved during the turn
    private int starvedPercentage; // Percentage of residents starved during the turn
    private int year; // The year of the city

    public int getAcres () {
        return acres;
    }

    public void setAcres (int acres) {
        this.acres = acres;
    }

    public int getAteByRates () {
        return ateByRates;
    }

    public void setAteByRates (int ateByRates) {
        this.ateByRates = ateByRates;
    }

    public int getBushels () {
        return bushels;
    }

    public void setBushels (int bushels) {
        this.bushels = bushels;
    }

    public int getBushelsHarvested () {
        return bushelsHarvested;
    }

    public void setBushelsHarvested (int bushelsHarvested) {
        this.bushelsHarvested = bushelsHarvested;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getNewResidents () {
        return newResidents;
    }

    public void setNewResidents (int newResidents) {
        this.newResidents = newResidents;
    }

    public int getResidents () {
        return residents;
    }

    public void setResidents (int residents) {
        this.residents = residents;
    }

    public int getStarved () {
        return starved;
    }

    public void setStarved (int starved) {
        this.starved = starved;
    }

    public int getStarvedPercentage () {
        return starvedPercentage;
    }

    public void setStarvedPercentage (int starvedPercentage) {
        this.starvedPercentage = starvedPercentage;
    }

    public int getYear () {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public Random getRandom () {
        return random;
    }

    public void setRandom (Random random) {
        this.random = random;
    }

    public int getPriceToBuy () {
        return priceToBuy;
    }

    public void setPriceToBuy (int priceToBuy) {
        this.priceToBuy = priceToBuy;
    }

    public int getPriceToSell () {
        return PriceToSell;
    }

    public void setPriceToSell (int priceToSell) {
        PriceToSell = priceToSell;
    }

    public City (int acres, int ateByRates, int bushels, int bushelsHarvested, String name, int newResidents,
                 int residents, int starved, int starvedPercentage, int year) {
        this.acres = acres;
        this.ateByRates = ateByRates;
        this.bushels = bushels;
        this.bushelsHarvested = bushelsHarvested;
        this.name = name;
        this.newResidents = newResidents;
        this.residents = residents;
        this.starved = starved;
        this.starvedPercentage = starvedPercentage;
        this.year = year;

    }


    Random random = new Random ();

    public City () {
        this.bushels = 2800;
        this.acres = 1000;
        this.residents = 150;
        this.name = "Hamurabi";
        this.starved = 0;
        this.starvedPercentage = 0;
    }

    int priceToBuy = random.nextInt (17, 26);

    public boolean buy (int priceToBuy, int pAmount) {
        if (priceToBuy * pAmount < this.bushels && pAmount >= 0) {
            this.acres += pAmount;
            this.bushels -= priceToBuy * pAmount;
            return true;
        } else {
            return false;
        }
    }

    int PriceToSell = random.nextInt (17, 26);

    public boolean sell (int priceToSell, int pAmount) {
        if (pAmount <= this.acres && pAmount >= 0) {
            this.acres -= pAmount;
            this.bushels += priceToSell * pAmount;
            return true;
        } else {
            return false;
        }
    }

    public boolean feed (int pAmountBushels) {
        if (pAmountBushels <= this.acres) {

            this.bushels -= pAmountBushels;
            return true;
        } else {
            return false;
        }

    }

    public boolean plante (int pAmountAcres) {
        if (pAmountAcres <= this.acres && pAmountAcres <= this.bushels && this.residents * 10 <= pAmountAcres) {
            this.acres -= pAmountAcres;
        }
        return false;
    }

    public void hungersnot () {
        if (bushels >= this.residents * 20) {
            this.bushels -= this.residents * 20;
            this.starved = 0;
            this.starvedPercentage = 0;
        } else {
            double result = (double) (this.residents * 20 - bushels) / 20;
            this.starved = (int) Math.ceil (result);
            this.starvedPercentage = this.starved * 100 / this.residents;
        }
    }

    public void einwohnerzuwachs () {
        double deathRate = (double) this.starved / this.residents;
        if (deathRate <= 0.4) {
            double growthRate = random.nextDouble () * 0.4;
            this.newResidents = (int) Math.floor (this.residents * growthRate);
            this.residents = (int) Math.floor (this.residents * (1 + growthRate));//new population after run
        }
    }

    public void gesamternte () {
        double ernteFaktor = 6.0;
        double z = 0.1 + Math.random () * 0.9; // Generiere eine Zufallszahl im Intervall [0.1, 1.0)
        double ernteRate = ernteFaktor * z;
        double ernte = this.bushels * ernteRate;
        this.bushels += (int) Math.floor (ernte);

    }

    public void rattenPlage () {
        double r = 25.0;
        double ateByRatesRate = random.nextDouble () * r;
        this.ateByRates = (int) (ateByRatesRate / 100) * this.bushels;
        this.bushels -= this.ateByRates;
    }

    public void neuesJahr () {
        this.year += 1;
    }

    public void runTurn () {
        hungersnot ();
        einwohnerzuwachs ();
        gesamternte ();
        rattenPlage ();
        neuesJahr ();
    }

    public void showStatus () {
        System.out.println ("In the year " + this.year + " after its foundation, " + this.residents + " inhabitants " + "live in the town of Codeopolis.\n " + "The town owns " + this.bushels + " bushels of grain and " + this.acres + " acres of land.");
    }
}
