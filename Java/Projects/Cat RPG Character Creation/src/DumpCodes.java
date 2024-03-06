/*
*
*
*
*     void determineCatValueList() {
        String buffer = "";
        String catValueBuffer;
//        int response = playerResponse;x
        int select = playerSelect -2;
        System.out.printf("\nCat Value In ----- %s ----- \n", catValue);
        System.out.printf("\ndetermineCatValueList() In ---- Player Select: %d \n", playerSelect);
        System.out.printf("determineCatValueList()In ---- Player Response: %d \n", playerResponse);
        System.out.printf("\nBuffer = BEFORE: ----------- %s -----------\n", buffer);
        for(byte i = 0; i< catValueList.size(); i++){
            if( select == i+1){

                System.out.printf("Player Response: %d\n", playerResponse);

                System.out.printf("Player Select: %d\n", playerSelect);
                System.out.printf("Index i: %d\n", i);

                System.out.printf("(NO -1) Index select: %d\n", select);
                System.out.printf("\nCat Value BETWEEN ----- %s ----- \n", catValue);

                catValueBuffer = catValue;
                buffer = catValueList.get(select).replace("None", catValueBuffer);
                System.out.printf("Index i: %d\n", i);
                System.out.printf("(YES -1) Index select: %d\n", i+1);

//                    buffer = userOptions[i].replace("None", catValue);
                System.out.printf("\nBuffer = BETWEEN: ----------- %s -----------\n", buffer);
                System.out.printf("\nCatValueList BEFORE: %s\n", catValueList.get(select));
                catValueList.set(select, buffer);
                System.out.printf("\nCatValueList AFTER: %s\n", catValueList.get(select));
//            break;
            }
            else{
                System.out.printf("Player Response: %d\n", playerResponse);

                System.out.printf("Player Select: %d\n", playerSelect);
                System.out.printf("Index i: %d\n", i);

                System.out.printf("(-1) Index select: %d\n", select);
                System.out.printf("(-2) Index select: %d\n", select-1);

                break;
            }
        }

        catValueBuffer ="None";
        buffer = "";
        System.out.printf("\nBuffer = AFTER: ----------- %s -----------\n", buffer);
        System.out.printf("\nCat Value Out ----- %s ----- \n", catValueBuffer);

//        response = 0;
//        select = 0;
        playerSelect = 0;
        playerResponse = 0;

    }

        int index = playerSelect - 1;

        if (index >= 0 && index < catValueList.size()) {
            buffer = catValueList.get(index).replace("None", catValue);
            System.out.printf("\nBuffer: %s\n", buffer);
            System.out.printf("\nCatValueList before: %s\n", catValueList.get(index));
            catValueList.set(index, buffer);
            System.out.printf("\nCatValueList after: %s\n", catValueList.get(index));

            buffer = "";
        } else {
            System.out.println("Invalid index, update failed");
        }
        for(byte i = 0; i < catValueList.size(); i++){
            System.out.printf("\nPlayerSelect: %d", playerSelect);
            if(playerSelect  == i+1 ){
                buffer = catValueList.get(i).replace("None", catValue);
                System.out.println(buffer + " buffer?");
                System.out.printf("\nList Array %d: %s\n",i+1, catValueList.get(i));
                catValueList.set(i, buffer);
                System.out.printf("CAtValueListArrList: %s", catValueList.get(i));


                break;
            }
            else{
                System.out.println("IDIIIOOOOOTTT!!!");
                break;
            }

        }
        buffer = " none";
        System.out.printf("buffer:?? %s", buffer);
    }

*
*
*
*
*
*
*
*
*
*
* */