
import java.util.Scanner;
class Character {
    Scanner input = new Scanner(System.in);
    int response;
    String name, race, charClass, job, gender, stringBuffer;
    String[] raceArr = {"Elf", "Dwarf", "Human", "Vampire", "Demon", "Angel"};
    String[] genderArr = {"Male", "Female"};
    String[] charClassArr = {"Magician", "Fighter", "Rangers", "Rogue", "Clerics", "Rare"};
    String[][] jobArray = {{"Light Mage", "Dark Mage", "Summoner"},
            {"Holy Knight", "Warrior"},
            {"Archer"},
            {"Assassin", "Ninja"},
            {"Healer", "Priest"},
            {"Spell-Weaver", "Beast-Tamer", "Bard"}};


    void playerChoose() {
        response = 0;
        System.out.print("Choose: ");
        response = input.nextInt();
    }
    void enterString(){
/*
        String stringBuffer;
*/      input.nextLine();
        System.out.print("Enter: ");
        stringBuffer = input.nextLine();
//        System.out.println(name);

    }

    void displayArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("\t " + (i + 1) + ". " + array[i]);
        }
    }

    /*    void display2dArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j )
            System.out.println("\t " + (i + 1) + ". " + array[i]);
        }
    }*/
    void determineRace() {
        for(int i = 0; i < raceArr.length; i++) {
            if (response == i + 1) {
                race = raceArr[i];
            }
        }
    }

    void determineGender() {
        for(int i = 0; i < genderArr.length; i++){
            if(response == i + 1){
                gender = genderArr[i];
                break;
            }
        }
    }

    void determineCharClass() {
        for (int i = 0; i < charClassArr.length; i++) {
            if (response == i + 1) {
                charClass = charClassArr[i];
                break;
            }
        }
    }


/*    void determineJobByClass(String[] charClassArr) {
        if (charClassArr[0].equals(charClass)) {
            displayArray(jobArray[0]);
        } else if (charClassArr[1].equals(charClass)) {
            displayArray(jobArray[1]);
        } else if (charClassArr[2].equals(charClass)) {
            displayArray(jobArray[2]);
        } else if (charClassArr[3].equals(charClass)) {
            displayArray(jobArray[3]);
        } else if (charClassArr[4].equals(charClass)) {
            displayArray(jobArray[4]);
        } else if (charClassArr[5].equals(charClass)) {
            displayArray(jobArray[5]);
        } else {
            System.out.println("Invalid Character Class");

        }*/
    void determineName(){
       if(stringBuffer != null)
           name = stringBuffer;;

    }



    void determineJobByClass(String[] charClassArr) {
        for (int i = 0; i < charClassArr.length; i++) {
            if (charClassArr[i].equals(charClass)) {
                displayArray(jobArray[i]);
                return; // Exit the loop after displaying the jobs for the selected class
            }
        }

        System.out.println("Invalid Character Class");
    }

    void playerChooseJob(String[] jobArray) {
        System.out.print("Choose: ");
        int jobChoice = input.nextInt();

        // Validate the user's choice
        if (jobChoice >= 1 && jobChoice <= jobArray.length) {
            job = jobArray[jobChoice - 1];
            System.out.println("\nYou picked " + job + " as your Job.\n");
        } else {
            System.out.println("Invalid Job choice.");
        }
    }

    void getPlayerJob(){
        int classIndex = response - 1; // Adjust the index to start from 0
        if (classIndex >= 0 && classIndex < jobArray.length) {
            playerChooseJob(jobArray[classIndex]);
        } else {
            System.out.println("Invalid Character Class choice.");
        }
    }


}
public class Main {
    public static void main (String[] args)
    {
//        Scanner input = new Scanner(System.in);

       /* char yesOrNo;

        do{

            System.out.print("\nStart? (y/n): ");
            yesOrNo = input.next().toUpperCase().charAt(0);
            if(yesOrNo == 'Y' ){
                break;
            }
            else if (yesOrNo != 'N'){
                System.out.println("Invalid Response!");
                continue;
            }
        }while(true);*/

        Character playerOne = new Character();
        System.out.println("RPG Character Creation ver.1 \n");
        System.out.println("\n\n***************Create Character***************\n");


        /* ********************************CHARACTER GENDER******************************** */

        System.out.println("Character Gender: \n");

        playerOne.displayArray(playerOne.genderArr);

        System.out.print("\n");
        playerOne.playerChoose();
        playerOne.determineGender();

        System.out.println("\nYou picked " + playerOne.gender + " as your Character Gender.\n");




        /* ********************************CHARACTER RACE******************************** */

        System.out.println("Character Race: \n");

        playerOne.displayArray(playerOne.raceArr);
        System.out.print("\n");
        playerOne.playerChoose();
        playerOne.determineRace();

        System.out.println("\nYou picked " + playerOne.race + " as your Character Race.\n");



        /* ********************************CHARACTER CLASS******************************** */

        System.out.println("Character Class: \n");

        playerOne.displayArray(playerOne.charClassArr);
        System.out.print("\n");
        playerOne.playerChoose();
        playerOne.determineCharClass();

        System.out.println("\nYou picked " + playerOne.charClass + " as your Character Class.\n");



        /* ********************************CHARACTER JOB******************************** */

        System.out.println("Choose your Job: \n");

        playerOne.determineJobByClass(playerOne.charClassArr);
        System.out.print("\n");
        playerOne.getPlayerJob();

        // Now 'playerOne.job' contains the selected job


        /* ********************************CHARACTER NAME******************************** */

        System.out.println("Enter your desired character name: ");

        playerOne.enterString();
        playerOne.determineName();

        System.out.println("\nYour character is now named \"" +playerOne.name+ "\". " );







    }
}
