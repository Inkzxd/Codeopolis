import java.util.Random;
import java.util.Scanner;

public class TextInterface implements UserInterface {
    City city = new City();
    private Scanner scanner;
    private Random random;

    int acresToBuy;
    int acresToSell;

    public TextInterface(City city) {
        this.random = new Random();
        this.city = city;
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        System.out.println("===== MAIN MENU =====");
        System.out.println("1. NEW GAME");
        System.out.println("2. QUIT");
        System.out.print("Please select an option: ");
    }

    public void showGameMenu() {
        System.out.println("===== GAME MENU =====");
        System.out.println("1. BUY");
        System.out.println("2. SELL");
        System.out.println("3. FEED");
        System.out.println("4. PLANT");
        System.out.println("5. SHOW STATUS");
        System.out.println("6. QUIT GAME");
        System.out.print("Please select an action: ");
    }

    public void showBuyMenu() {
        int priceToBuy = random.nextInt(17, 26);
        System.out.println("===== BUY MENU =====");
        System.out.println("City Status: " + city.showStatus());
        System.out.println("Current price per acre: " + priceToBuy);
        System.out.print("How many acres would you like to buy? ");
        this.acresToBuy = scanner.nextInt();
        boolean success = city.buy(priceToBuy, acresToBuy);
        if (success) {
            System.out.println("You bought " + acresToBuy + " acres.");
            System.out.println("New Status: " + city.showStatus() + "\n");
        } else {
            System.out.println("Purchase failed. Please check your input and available resources.");
        }
    }

    public void showSellMenu() {
        int priceToSell = random.nextInt(17, 26);
        System.out.println("===== SELL MENU =====");
        System.out.println("City Status: " + city.showStatus());
        System.out.println("Current price per acre: " + priceToSell);
        System.out.print("How many acres would you like to sell? ");
        this.acresToSell = scanner.nextInt();
        boolean success = city.sell(priceToSell, acresToSell);
        if (success) {
            System.out.println("New Status: " + city.showStatus() + "\n");
        } else {
            System.out.println("Purchase failed. Please check your input and available resources.");
        }

    }

    public void showFeedMenu() {
        System.out.println("===== FEED MENU =====");
        System.out.println("City Status: " + city.showStatus());
        System.out.print("How many bushels do you want to feed to your residents? ");
        int bushelsToFeed = scanner.nextInt();
        boolean success = city.feed(bushelsToFeed);
        if (success) {
            System.out.println("New Status: " + city.showStatus() + "\n");
        } else {
            System.out.println("Purchase failed. Please check your input and available resources.");
        }
    }

    public void showPlantMenu() {
        System.out.println("===== PLANT MENU =====");
        System.out.println("City Status: " + city.showStatus());
        System.out.print("How many acres of land do you wish to plant with seed? ");
        int acresToPlant = scanner.nextInt();
        boolean success = city.plante(acresToPlant);
        if (success) {
            System.out.println("New Status: " + city.showStatus() + "\n");
        } else {
            System.out.println("Purchase failed. Please check your input and available resources.");
        }
    }

    public void showStatusMenu() {
        System.out.println("===== STATUS MENU =====");
        System.out.println("City Status: " + city.showStatus());
    }

    public void startGame() {
        showMainMenu();
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                gameLoop();
                break;
            case 2:
                System.out.println("Quitting game. Goodbye!");
                break;
            default:
                System.out.println("Invalid Input. Please enter a valid option.");
                break;
        }
    }

    public void gameLoop() {
        System.out.println("Year: " + city.neuesJahr());

        showBuyMenu();

        showSellMenu();

        showFeedMenu();

        showPlantMenu();

    }

    @Override
    public int buy(int pricePerAcre, City city) {
        int cost = pricePerAcre * this.acresToBuy;
        if (cost <= city.getBushels() && this.acresToBuy > 0) {
            city.setBushels(city.getBushelsHarvested() - cost);
            city.setAcres(city.getAcres() + this.acresToBuy);
            return this.acresToBuy;
        }
        return 0;
    }

    @Override
    public int sell(int pricePerAcre, City city) {
        int acresSold = pricePerAcre * this.acresToSell;
        if (acresSold <= city.getBushels() && this.acresToSell > 0) {
            city.setBushels(city.getBushels() + acresSold);
            city.setAcres((city.getAcres() - this.acresToSell));
            return this.acresToSell;
        }
        return 0;
    }

    @Override
    public int feed(int bushelsPerResident, City city) {
        return 0;
    }

    @Override
    public int plant(int bushelsPerAcre, int acrePerResident, City city) {
        return 0;
    }

    @Override
    public void turnEnd(TurnResult result) {

    }

    @Override
    public void illegalInput(String message) {

    }

    @Override
    public void gameWon(String message) {

    }

    @Override
    public void gameLost(String message) {

    }
}
