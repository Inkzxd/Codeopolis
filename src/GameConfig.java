

class GameConfig {
    private int initialResidents;
    private int initialAcres;
    private int initialBushels;
    private int maxAcrePrice;
    private int minArcrPrice;
    private int bushelsPerResident;
    private int bushelsPerAcre;
    private int acrePerResident;
    private int numberOfYears;
    private float harvestFactor;
    private int rateInfestation;
    private DifficultyLevel level;


    public void GameConfig(DifficultyLevel level) throws IllegalAccessException {
        switch (level) {
            case EASY:
                initialResidents = 100;
                initialAcres = 1000;
                initialBushels = 2800;
                maxAcrePrice = 30;
                minArcrPrice = 10;
                bushelsPerResident = 20;
                bushelsPerAcre = 1;
                acrePerResident = 10;
                numberOfYears = 10;
                harvestFactor = 6.0F;
                rateInfestation = 10;
                break;

            case MEDIUM:
                initialResidents = 100;
                initialAcres = 900;
                initialBushels = 2800;
                maxAcrePrice = 35;
                minArcrPrice = 15;
                bushelsPerResident = 22;
                bushelsPerAcre = 1;
                acrePerResident = 10;
                numberOfYears = 10;
                harvestFactor = 5.0F;
                rateInfestation = 20;
                break;

            case HARD:
                initialResidents = 100;
                initialAcres = 800;
                initialBushels = 2800;
                maxAcrePrice = 35;
                minArcrPrice = 15;
                bushelsPerResident = 24;
                bushelsPerAcre = 1;
                acrePerResident = 10;
                numberOfYears = 10;
                harvestFactor = 4.0F;
                rateInfestation = 25;
                break;
            default:
                throw new IllegalAccessException("invalid difficulty level");
        }
    }
}