            System.out.printf("\n\tStudent Number #%d\n", (i+1));
            System.out.print("\nName of Student: ");
            studName = in.nextLine();

            // Checks if the user haven't input a name
            if(studName.isEmpty()){
                System.out.println("\nYou need to input a name, try again!\n");
                i--;
                continue;