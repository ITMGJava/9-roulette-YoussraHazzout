import java.util.Random;
import java.util.Scanner;
public class Roulette {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();
        double startbedrag = 100;
        double bedrag;
        int keuze, win = 0, lose = 0, spin = 0;
        double nummer;
        int rouletteNum;
        double resultaat;
        char antwoord = 'y';
        int resultArr[] = new int[36];
        int r = 0;
        for (spin = 0 ; spin < 10;) {
            while (antwoord == 'y' || antwoord == 'Y' && startbedrag <= 0) {
                System.out.println("Voer een bedrag in: ");
                bedrag = keyboard.nextDouble();
                System.out.println("0 - Even\n1 - Oneven");
                keuze = -1;
                while (keuze < 0 || keuze > 2) {
                    System.out.println("Kies je gok op:");
                    keuze = keyboard.nextInt();
                }
                nummer = 0;
                if (keuze == 2) {
                    while (nummer < 1 || nummer > 36) {
                        System.out.print("Gok op een nummer (1-36): ");
                        nummer = keyboard.nextInt();
                    }
                }
                rouletteNum = generator.nextInt(37);
                spin++;
                System.out.println("Roulette nummer: " + rouletteNum);

                if (keuze == 2) {
                    if (rouletteNum == nummer)
                        resultaat = 35;
                    else
                        resultaat = 0;
                } else {
                    if (rouletteNum == 0 || rouletteNum % 2 != keuze)
                        resultaat = 0;
                    else
                        resultaat = 1;
                }

                //Print out game result, win/lose amount
                if (resultaat > 0) {
                    win++;
                    System.out.println("$$------------------------------------$$");
                    System.out.println("Gefeliciteerd, je hebt gewonnen!");
                    System.out.println("$$------------------------------------$$");
                    System.out.printf("Je hebt dit bedrag gewonnen: $%.2f \n", bedrag);
                    System.out.println("Je hebt "+win+"x gewonnen en " +lose+ "x verloren");
                    System.out.println("Dit is ronde:"+spin);
                    System.out.printf("Je huidige portomonee bevat:", resultaat + startbedrag + bedrag);
                    startbedrag = resultaat * bedrag + startbedrag;
                    resultArr[rouletteNum]++;

                } else {
                    lose++;
                    System.out.println("Aww, je hebt verloren. Volgende keer beter...:(");
                    System.out.println("Je verliest:-$" +bedrag);
                    System.out.println("Je hebt "+win+"x gewonnen en " +lose+ "x verloren");
                    System.out.println("Dit is ronde:"+spin);
                    System.out.println("Je hebt nog $" + (startbedrag - bedrag));
                    startbedrag = startbedrag - (bedrag);
                    resultArr[rouletteNum]++;

                    if (startbedrag <= 0) {
                        break;
                    }

                }

                //nogmaals spelen
                for (int totaal = 1; totaal < 36; totaal++) {
                    if (resultArr[totaal] > 0) {

                    }
                }



                System.out.println("\nWil je nogmaals spelen? (y/n) ");
                antwoord = keyboard.next().charAt(0);


            }

        }
    }
}