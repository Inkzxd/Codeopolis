public class City{

    private String name;
    private int bushels;
    private int acres;
    private int population;

    public int getYear () {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public int getUsedBushels () {
        return usedBushels;
    }

    public void setUsedBushels (int usedBushels) {
        this.usedBushels = usedBushels;
    }

    private int usedBushels;
    private int year;

    public City () {
        this.bushels = 2800;
        this.acres = 1000;
        this.population = 100;
        this.name = "Hamurabi";
    }

    public boolean buy (int pCost, int pAmount) {
        if (pCost * pAmount < this.bushels) {
            this.acres += pAmount;
            this.bushels -= pCost * pAmount;
            return true;
        } else {
            return false;
        }
    }

    public boolean sell (int pCost, int pAmount) {
        if (pAmount <= this.acres) {
            this.acres -= pAmount;
            this.bushels += pCost * pAmount;
            return true;
        } else {
            return false;
        }
    }

    public boolean feed (int pAmountBushels) {
        if (pAmountBushels <= this.acres) {

            this.bushels -= pAmountBushels;
            this.usedBushels = pAmountBushels;
            return true;
        } else {
            return false;
        }

    }

    public boolean plante (int pAmountAcres) {
        if (pAmountAcres <= this.acres && pAmountAcres <= this.bushels && this.population * 10 <= pAmountAcres) {
            this.acres -= pAmountAcres;
        }
        return false;
    }

    public void toStringHamurabi () {
        System.out.println ("Year: " + this.year);
        System.out.println ("CityName: " + this.name);
        System.out.println ("Population: " + this.population);
        System.out.println ("Bushels: " + this.bushels);
        System.out.println ("Acres: " + this.acres);
    }
}
