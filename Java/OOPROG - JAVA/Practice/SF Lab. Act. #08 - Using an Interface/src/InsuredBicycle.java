import javax.swing.*;

public class InsuredBicycle extends Vehicle implements Insured{

    private int coverage;

    public InsuredBicycle(){
        super("a person", 2);
        setCoverage();
    }
    public int getValidInput(String showMsg, String showAlert, String paneTitle){
        int temp = 0;

        while(true){
            String input = JOptionPane.showInputDialog(null, showMsg, paneTitle, JOptionPane.QUESTION_MESSAGE);


            if(input == null){
                JOptionPane.showMessageDialog(null, "Option Pane Exited", "Warning", JOptionPane.WARNING_MESSAGE);
                break;
            }

            if(input.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Input a number to continue!", "Warning", JOptionPane.WARNING_MESSAGE);
                continue;
            }


            try{
                temp = Integer.parseInt(input);
                break;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, showAlert, "Invalid Input", JOptionPane.ERROR_MESSAGE);
                continue;
            }


        }

        return temp;

    }



    @Override
    public void setCoverage() {
        coverage =(int) (price * 0.9);
    }

    @Override
    public int getCoverage() {
        return this.coverage;
    }

    @Override
    public void setPrice() {
        final int MAX = 60000;
        price = getValidInput("Enter Bicycle price: ",
                "Invalid input for Bicycle!",
                "Input Bicycle Price");

        if(price > MAX){
            price = MAX;
        }

    }

    @Override
    public String toString(){
        String notZero = "The Insured Bicycle is powered by " +
                getPowerSource() + " it has " +
                getWheels() + " wheels, costs $" +
                getPrice()
                + " and is insured for $" + getCoverage();
        String varIsZero =  "The user didn't provide enough information for the Bicycle";


        return (price == 0) ? varIsZero : notZero;

    }
}
