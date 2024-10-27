package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlaceData{

    public static PlaceData pDInstance;

    final String imgPathLoc = "src/assets/places";
    private ImageIcon[] touristSpotImages;
    private String[][] touristSpots = {
            {
                    "Magellan’s Cross",
                    "Magallanes Street, Cebu City",
                    "A historic landmark symbolizing the arrival of Christianity in the Philippines, brought by Ferdinand Magellan in 1521.",
                    "Historical Site",
                    "Jeepney, Tricycle, Motorcycle Taxi"
            },
            {
                    "Basilica del Santo Niño",
                    "Osmeña Boulevard, Cebu City",
                    "The oldest Roman Catholic Church in the Philippines, housing the famous Santo Niño statue.",
                    "Church / Historical Site",
                    "Jeepney, Pedicab, Motorcycle Taxi"
            },
            {
                    "Fort San Pedro",
                    "Plaza Independencia, Cebu City",
                    "A military defense structure from the Spanish era, now serving as a museum and park.",
                    "Historical Fort",
                    "Jeepney, Tricycle, Bicycle"
            },
            {
                    "Temple of Leah",
                    "Cebu Transcentral Highway, Busay, Cebu City",
                    "A grand Roman-style temple dedicated to Leah Villa Albino-Adarna, showcasing scenic views and statues.",
                    "Temple / Viewpoint",
                    "Motorcycle Taxi, Private Car, Jeepney"
            },
            {
                    "Sirao Flower Garden",
                    "Sirao, Busay, Cebu City",
                    "Known as the 'Little Amsterdam' of Cebu, this vibrant flower garden is a popular photography spot.",
                    "Garden / Nature Spot",
                    "Jeepney, Motorcycle Taxi, Private Car"
            },
            {
                    "Tops Lookout",
                    "Cebu Tops Rd, Cebu City, 6000 Cebu",
                    "A hilltop viewpoint offering panoramic views of Cebu City, especially beautiful at sunset.",
                    "Scenic Viewpoint",
                    "Motorcycle Taxi, Jeepney, Private Car"
            },
            {
                    "Cebu Taoist Temple",
                    "Beverly Hills Subdivision, Lahug, Cebu City",
                    "Brightly painted hillside pagodas & prayer halls with striking dragon designs & views over the city.",
                    "Temple",
                    "Jeepney, Motorcycle Taxi, Private Car"
            },
            {
                    "Casa Gorordo Museum",
                    "35 Eduardo Aboitiz St, Cebu City, 6000 Cebu",
                    "Built in the 1850s, this former residence of Juan Gorordo offers guided tours, a cafe & a gift shop.",
                    "Museum / Historical House",
                    "Jeepney, Bicycle, Motorcycle Taxi"
            },
            {
                    "Cebu Heritage Monument",
                    "Sikatuna St, Cebu City, 6000 Cebu",
                    "Series of sculptures commemorating important events & buildings from Cebu's colonial past.",
                    "Monument / Historical Site",
                    "Jeepney, Bicycle, Pedicab"
            },
            {
                    "Mountain View Nature Park",
                    "Cebu Transcentral Hwy, Cebu City, 6000 Cebu",
                    "A nature park offering camping grounds, swimming pools, and scenic views of the mountains and city.",
                    "Nature Park",
                    "Private Car, Motorcycle Taxi, Jeepney"
            },
            {
                    "SM City Cebu",
                    "2nd Level Cyberzone, SM City Cebu, Juan Luna Ave Ext, Cebu City, 6000 Cebu",
                    "Spacious retail center with a comprehensive mix of stores & eateries, plus a movie theater.",
                    "Shopping Mall",
                    "Private Car, Taxi, Jeepney"
            },
            {
                    "SM Seaside",
                    "Cebu South Coastal Rd, Antuwanga, Cebu City, 6000 Cebu",
                    "A waterfront shopping mall with a variety of shops, dining options, and an ocean view.",
                    "Shopping Mall",
                    "Private Car, Taxi, Jeepney"
            },
            {
                    "University of Cebu Main Campus",
                    "Sanciangko St, Cebu City, 6000 Cebu",
                    "A prominent university offering a wide range of undergraduate and graduate programs.",
                    "Educational Institution",
                    "Private Car, Motorcycle Taxi, Jeepney"
            },
            {
                    "Elizabeth Mall",
                    "Sanciangko St, Cebu City, 6000 Cebu",
                    "A popular shopping mall with various stores, eateries, and leisure facilities.",
                    "Shopping Mall",
                    "Private Car, Taxi, Jeepney"
            },
            {
                    "Barangay Tisa",
                    "Francisco Llamas St, Cebu City, 6000 Cebu",
                    "A vibrant neighborhood known for its local eateries and the \"Siomai sa Tisa\".",
                    "Baranggay",
                    "Private Car, Motorcycle Taxi, Jeepney"
            }

    };








    public void initImages(){

        File imgPath = new File(imgPathLoc);
        File[] placeImages = imgPath.listFiles();
        System.out.println(placeImages.length);
//        System.out.println(placeImages[0].getPath());

        if(placeImages == null){
            System.out.println("PlaceImages is null");
            return;
        }

        touristSpotImages = new ImageIcon[placeImages.length];

        for(int i =0; i < placeImages.length; i++){
            ImageIcon tempImg;
            try{
                String filePath = placeImages[i].getPath();
                System.out.println(filePath);
//                tempImg = new ImageIcon(ImageIO.read(placeImages[i]));
                tempImg = new ImageIcon(filePath) ;

                if(tempImg != null){
                    touristSpotImages[i] = tempImg;
                }
                else{
                    System.out.println("Failed to load image: " + filePath);
                }


            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println();


    }


    private PlaceData(){}

    public static PlaceData getInstance(){

        if(pDInstance == null){
            pDInstance = new PlaceData();
            pDInstance.initImages();

        }

        return pDInstance;
    }

    public ImageIcon[] getTouristSpotImages() {
        return touristSpotImages;
    }

    public String[][] getTouristSpots() {
        return touristSpots;
    }



}
