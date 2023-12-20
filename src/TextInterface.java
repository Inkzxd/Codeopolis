import java.util.Random;
import java.util.Scanner;

public class TextInterface{
    City city = new City ();
    private Scanner scanner;
    private Random random;


    public TextInterface (City city) {
        this.random = new Random ();
        this.city = city;
        this.scanner = new Scanner (System.in);
    }

    public void showMainMenu () {
        System.out.println ("===== MAIN MENU =====");
        System.out.println ("1. NEW GAME");
        System.out.println ("2. QUIT");
        System.out.print ("Please select an option: ");
    }

    public void showGameMenu () {
        System.out.println ("===== GAME MENU =====");
        System.out.println ("1. BUY");
        System.out.println ("2. SELL");
        System.out.println ("3. FEED");
        System.out.println ("4. PLANT");
        System.out.println ("5. SHOW STATUS");
        System.out.println ("6. QUIT GAME");
        System.out.print ("Please select an action: ");
    }

    public void showBuyMenu () {
        int priceToBuy = random.nextInt (17, 26);
        System.out.println ("===== BUY MENU =====");
        city.showStatus ();
        System.out.println ("Current price per acre: " + priceToBuy);
        System.out.print ("How many acres would you like to buy? ");
        int acresToBuy = scanner.nextInt ();
        boolean success = city.buy (priceToBuy, acresToBuy);
        if (success) {
            System.out.println ("You bought " + acresToBuy + " acres.");
        } else {
            System.out.println ("Purchase failed. Please check your input and available resources.");
        }
        city.showStatus ();
    }

    public void showSellMenu () {
        int priceToSell = random.nextInt (17, 26);
        System.out.println ("===== SELL MENU =====");
        city.showStatus ();
        System.out.println ("Current price per acre: " + priceToSell);
        System.out.print ("How many acres would you like to sell? ");
        int acresToSell = scanner.nextInt ();
        boolean success = city.sell (priceToSell, acresToSell);
        if (success) {
            city.showStatus ();
        } else {
            System.out.println ("Purchase failed. Please check your input and available resources.");
        }

    }

    public void showFeedMenu () {
        System.out.println ("===== FEED MENU =====");
        city.showStatus ();
        System.out.print ("How many bushels do you want to feed to your residents? ");
        int bushelsToFeed = scanner.nextInt ();
        boolean success = city.feed (bushelsToFeed);
        if (success) {
            city.showStatus ();
        } else {
            System.out.println ("Purchase failed. Please check your input and available resources.");
        }
    }

    public void showPlantMenu () {
        System.out.println ("===== PLANT MENU =====");
        city.showStatus ();
        System.out.print ("How many acres of land do you wish to plant with seed? ");
        int acresToPlant = scanner.nextInt ();
        boolean success = city.plante (acresToPlant);
        if (success) {
            city.showStatus ();
        } else {
            System.out.println ("Purchase failed. Please check your input and available resources.");
        }
    }

    public void showStatusMenu () {
        System.out.println ("===== STATUS MENU =====");
        city.showStatus ();
    }

    public void startGame () {
        showMainMenu ();
        int choice = scanner.nextInt ();

        switch (choice) {
            case 1:
                gameLoop ();
                break;
            case 2:
                System.out.println ("Quitting game. Goodbye!");
                break;
            default:
                System.out.println ("Invalid Input. Please enter a valid option.");
                break;
        }
    }

    public void gameLoop () {
        while (true) {
            showGameMenu ();
            int action = scanner.nextInt ();

            switch (action) {
                case 1:
                    showBuyMenu ();
                    break;
                case 2:
                    showSellMenu ();
                    break;
                case 3:
                    showFeedMenu ();
                    break;
                case 4:
                    showPlantMenu ();
                    break;
                case 5:
                    city.showStatus ();
                    break;
                case 6:
                    System.out.println ("Quitting game. Returning to Main Menu.");
                    return;
                default:
                    System.out.println ("Invalid Input. Please enter a valid option.");
                    break;
            }
        }
    }
}
