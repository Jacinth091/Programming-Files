package main;

import main.objects.Student;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BookStatusFrame  {

    //    private Color foreground = new Color(new Color());
    private Student student;
    private Helper helper = new Helper(); // HelperMethod Class
    private PlaceData plData = PlaceData.getInstance();

    private int index;


    private String userName;
    private String selPlaceName;
    private String selPlaceAddress;
    private String selVhItem;
    private int selVhIndex;

    public BookStatusFrame() {

    }
    public BookStatusFrame(Student student , int index, int selVhIndex, String selVhItem, String selPlaceAddress, String selPlaceName, String userName) {
        this.student =student;
        this.index = index;

        setSelPlaceName(selPlaceName);
        setSelPlaceAddress(selPlaceAddress);
        setUserName(userName);
        setSelVhItem(selVhItem);
        setSelVhIndex(selVhIndex);


    }

    public void displayBookingDetails(){
        String mainInfo = ("<html>" +
                "<p style='font-size: 14px;'>" +
                "Studdent Name: <span style='font-weight: bold;'>" + userName + "</span><br><br>" +
                "Place: <span style='font-weight: bold;'>" + selPlaceName + "</span><br>" +
                "Address: <span style='font-weight: bold;'>" + selPlaceAddress + "</span><br><br>" +
                "Selected Vehicle: <span style='font-weight: bold;'>" + selVhItem + "</span>" +
                "</p>" +
                "</html>");
//        mainInfoLabel =helper.createLabel(Color.WHITE);

        JOptionPane.showMessageDialog(null, new JLabel(mainInfo), "Booking Status", JOptionPane.INFORMATION_MESSAGE);


    }



    public void test(){

        student.getVehicle(plData.getVhArray()[selVhIndex]);
        student.travelTo(selPlaceName);
    }

    public void setSelVhIndex(int selVhIndex) {
        this.selVhIndex = selVhIndex;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSelPlaceAddress(String selPlaceAddress) {
        this.selPlaceAddress = selPlaceAddress;
    }

    public void setSelPlaceName(String selPlaceName) {
        this.selPlaceName = selPlaceName;
    }

    public void setSelVhItem(String selVhItem) {
        this.selVhItem = selVhItem;
    }

}
