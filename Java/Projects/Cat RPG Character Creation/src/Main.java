
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
        catOne.setArrayList();




        boolean isDone = false;

        do {
            // You are getting there, find a way to solve the problem
            // It loops everytime the user inputs the number it is unintended
            // If you picked one in the first choices, the second time it will loop back again to the second choices
            // unless you choose to input a different number than 1
            if(catOne.playerSelect == 1){
                catOne.createAndAssign(catOne.genderArr);
            }
            else if(catOne.response == 2 ){
                catOne.createAndAssign(catOne.eyeColorArr);
            }
            else if(catOne.response == 3 ){
                catOne.createAndAssign(catOne.colorArr);
            }
            else if(catOne.response == 4 ){
                catOne.createAndAssign(catOne.patternArr);
            }
            else if(catOne.response == 5 ){
                catOne.createAndAssign(catOne.ageArr);
            }
/*            else if(catOne.response == 2 ){
                catOne.createAndAssign(catOne.eyeColorArr);
            }*/


           /* switch(catOne.response){
                case 1:

                break;

                case 2:
                    catOne.displayArray(catOne.eyeColorArr);
                    catOne.playerSelect(catOne.eyeColorArr);
                    catOne.dispAndSelect(catOne.userOptions);
                break;

                case 3:
                    catOne.displayArray(catOne.colorArr);
                    catOne.playerSelect(catOne.colorArr);
                    catOne.dispAndSelect(catOne.userOptions);
                break;

                case 4:
                    catOne.displayArray(catOne.patternArr);
                    catOne.playerSelect(catOne.patternArr);
                    catOne.dispAndSelect(catOne.userOptions);
                break;

                case 5:
                    catOne.displayArray(catOne.ageArr);
                    catOne.playerSelect(catOne.ageArr);
                    catOne.dispAndSelect(catOne.userOptions);
                break;

                case 6:
                    catOne.displayArray(catOne.genderArr);
                    catOne.playerSelect(catOne.genderArr);
                    catOne.dispAndSelect(catOne.userOptions);
                    break;

                case 0:
                    isDone = true;
                    break;

            }*/
        }while(true);


/*        for(byte i = 0; i < catOne.userOptions.length; i++){
            catOne.dispAndSelect(catOne.userOptions);
            switch(catOne.response){
                case 1:

            }
        }*/


/*        switch (catOne.playerSelect){
            case 1:
                catOne.dispAndSelect(catOne.genderArr);
                catOne.displayArrayList();
                catOne.selectArrayList();
                break;
        }*/






//        catOne.gameState();
      /*  do {
            switch (catOne.playerSelect) {
                case 1:
                    catOne.dispAndSelect(catOne.genderArr);
                    catOne.determineCatValue(catOne.genderArr, catOne.catGender);
                    if (catOne.catGender != null) {
                        catOne.dispAndSelArrayList();
                        System.out.println(catOne.catGender);

                    }
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
                    System.exit(0);
                    break;
            }

        }while(catOne.playerSelect != 0);*/


//
//        catOne.displayArray(catOne.patternArr);
//        catOne.playerSelect(catOne.patternArr);

    }

}
