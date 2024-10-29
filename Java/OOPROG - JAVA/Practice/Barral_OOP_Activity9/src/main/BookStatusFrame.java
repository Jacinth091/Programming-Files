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
    private String selVhType;
    private int selVhIndex;

    public BookStatusFrame() {

    }
    public BookStatusFrame(Student student , int index, int selVhIndex, String selVhItem,String selVhType, String selPlaceAddress, String selPlaceName, String userName) {
        this.student =student;
        this.index = index;

        setSelPlaceName(selPlaceName);
        setSelPlaceAddress(selPlaceAddress);
        setUserName(userName);
        setSelVhItem(selVhItem);
        setSelVhType(selVhType);
        setSelVhIndex(selVhIndex);


    }

    public void displayBookingDetails(){
        String mainInfo = ("<html>" +
                "<p style='font-size: 14px; padding: 10px; word-wrap: break-word;'>" +
                "Student Name: <span style='font-weight: bold;'>" + userName + "</span><br><br>" +
                "Place: <span style='font-weight: bold;'>" + selPlaceName + "</span><br>" +
                "Address: <span style='font-weight: bold; word-wrap: break-word;'>" + selPlaceAddress + "</span><br><br>" +
                "Vehicle: <span style='font-weight: bold;'>" + selVhItem + "</span><br>" +
                "Type: <span style='font-weight: bold;'>" + selVhType + " based vehicle</span>" +
                "</p>" +
                "</html>");
        JLabel mainInfoLabel =helper.createLabel(null);
        mainInfoLabel.setText(mainInfo);

        student.getVehicle(plData.getVhArray()[selVhIndex]);
        student.travelTo(selPlaceName);

        JOptionPane.showMessageDialog(null, mainInfoLabel, "Booking Status", JOptionPane.INFORMATION_MESSAGE);
        String bookStatus = student.bookingTravelDestination(selPlaceName);

        mainInfoLabel.setText(bookStatus);

        JOptionPane.showMessageDialog(null, bookStatus, "Booking", JOptionPane.INFORMATION_MESSAGE);

        String closingMessage = ("<html>" +
                "<p style='font-size: 14px; padding: 10px; text-align: center;'>" +
                "Thank you for using the Booking Program, See you again<br><br>" +
                "<span style='font-weight: bold;'>Made by:</span> Barral Jacinth Cedric C.<br>" +
                "<span style='font-weight: bold;'>Course:</span> BSIT 2B" +
                "</p>" +
                "</html>");


        mainInfoLabel.setText(closingMessage);
        JOptionPane.showMessageDialog(null, mainInfoLabel, "Goodbye and Thank You", JOptionPane.INFORMATION_MESSAGE);
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

    public void setSelVhType(String selVhType) {
        this.selVhType = selVhType;
    }
}
