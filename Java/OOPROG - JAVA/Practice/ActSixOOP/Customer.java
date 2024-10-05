package ActSixOOP;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private VehicleData vhDB = VehicleData.getInstance();

    private String name;
    private String occupation;
    private String loyaltyStatus;
    private boolean hasRentedAVehicle = false;

    private VehicleManager[] rentedVehicles;
    private int rentalDuration;
    private double totalRentalCost;

    // Constructor
    public Customer(String name, String occupation, String loyaltyStatus) {
        this.name = name;
        this.occupation = occupation;
        this.loyaltyStatus = loyaltyStatus;
        this.rentedVehicles = new VehicleManager[vhDB.getObjectSize()];
        this.rentalDuration = 0;
        this.totalRentalCost = 0.0;
    }


    public void viewCustomerStatus(){




    }

/*    public void viewVehicleHistory(){



        if(rentedVehicles == null){
            System.out.println("Rented Vehicles List is NULL!");
        }
        else{
            String[] columnHeader = {"Type", "Model", "Rent Status", "Remaining Days", "Date Rented"};

            for(VehicleManager vhManager : rentedVehicles){
                int vehicleTypeLen = getStrLen(vhManager));
                int vehicleModelLen = getStrLen(vhManager.getVehicleModel());





            }
        }


    }*/

//    public static void dispStudentInfo(StudentData studentData){
//        String[][] studAtts = studentData.getStudAttributes();
//        double[] studAve = studentData.getStudAve();
//
//        int courseLen = getStrLen(studAtts[1]);
//        int nameLen = getStrLen(studAtts[0]);
//        int finalLen;
//
//        for(int i =0; i < studAtts.length; i++){
//            finalLen = nameLen > courseLen ? nameLen + 2 : courseLen + 2;
////            System.out.println(finalLen);
//            System.out.printf("%8sName: %-"+ (finalLen)+"s   ID No. %s\n"," ", studAtts[i][0].trim(), studAtts[i][3].trim());
//            System.out.printf("%8sCourse: %-"+(finalLen)+"s Section: %s\n"," ", studAtts[i][1].trim(), studAtts[i][2].trim());
//            System.out.printf("%8sAverage: %-"+(finalLen)+".2fRanking: %s\n"," ", studAve[i], studAtts[i][4].trim());
//            System.out.println();
//        }
//    }



    public int getStrLen(List<String> orgStr){
        int len = 0;
        for(String str : orgStr){
            if(str.length() > len){
                len = str.length();
            }
        }

        return len;
    }

    public int getStrLen(String orgStr){
        int len = 0;

        if(orgStr.length() > len){
            len = orgStr.length();
        }

        return len;
    }





}
