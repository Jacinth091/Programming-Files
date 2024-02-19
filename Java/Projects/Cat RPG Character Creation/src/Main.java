
public class Main {
    public static void main(String[] args) {

        System.out.println("\n====================================================================");
        System.out.println("\t\t\t\tRPG Cat Character Creation ver. 2");
        System.out.println("====================================================================\n");

        System.out.println("\n====================================================================");
        System.out.println("--------------------------CREATE YOUR CAT---------------------------");
        System.out.println("====================================================================\n");

        CreateCatPlayer catOne = new CreateCatPlayer();

        catOne.displayArray(catOne.userOptions);
        catOne.playerSelect(catOne.userOptions);

        catOne.gameState();

/*        switch(catOne.playerSelect){
            case 1:
                catOne.dispAndSelect(catOne.genderArr);
                catOne.determineCatValue(catOne.genderArr, catOne.catGender);
                break;
            case 2:
                catOne.dispAndSelect(catOne.eyeColorArr);
                catOne.determineCatValue(catOne.eyeColorArr, catOne.catEyeColor);
                break;
            case 3:
                catOne.dispAndSelect(catOne.colorArr);
                catOne.determineCatValue(catOne.colorArr, catOne.catColor);
                break;
            case 4:
                catOne.dispAndSelect(catOne.patternArr);
                catOne.determineCatValue(catOne.patternArr, catOne.catPattern);
                break;
            case 5:
                catOne.dispAndSelect(catOne.ageArr);
                catOne.determineCatValue(catOne.ageArr, catOne.catAge);
                break;
            case 6:

                break;
            case 0:
                System.out.println("Bye!");

                break;



        }*/


//
//        catOne.displayArray(catOne.patternArr);
//        catOne.playerSelect(catOne.patternArr);

    }

}
