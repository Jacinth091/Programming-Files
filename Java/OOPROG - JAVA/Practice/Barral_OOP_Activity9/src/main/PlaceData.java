package main;

import main.objects.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlaceData {

    public static PlaceData pDInstance;
    private Helper helper = new Helper();
    private final int imageScale = 1;
    private final int imageWidth = 1920 / imageScale, imageHeight = 1080 / imageScale;
    private String[] vehicleNames;
//    final String imgPathOne = "assets/places";
//    final String imgPathTwo = "src/assets/places";

    final String[] imgPaths = {
            "src",
            "mmamammama",
            "assets/places",
            "src/assets/places",

    };

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

    private Vehicle[] vhObjs = {
            new Jeepney("Jeepney", "Land"),
            new Motorcycle("Motorcycle", "Land"),
            new Helicopter("Helicopter", "Air"),
            new Sailboat("Sailboat", "Water"),
            new Bicycle("Bicycle", "Land")
    };


    public void initImages() {
        int pathIndex = -1;
        File[] paths = new File[imgPaths.length];
        File[] placeImages = null;

        // Load all the paths in imgPaths String array
        try {
            for (int i = 0; i < paths.length; i++) {
                paths[i] = new File(imgPaths[i]);

                // Checking if the current path exist or a directory
                if (paths[i].exists() && paths[i].isDirectory() && !paths[i].getPath().equals("src")) {
                    pathIndex = i;
                    break;  // If it is valid, use the index and break out of the loop
                } else {
                    System.out.println("Invalid path at index " + i + ": " + paths[i].getPath());
                }
            }

            if (pathIndex == -1) {
                throw new IOException("No valid paths to initialize images.");
            }
            // Logging into console if valid index found
            System.out.println("Valid path found at index " + pathIndex + ": " + paths[pathIndex].getPath());
            placeImages = paths[pathIndex].listFiles();

            // Check if the image array is null (no files in directory)
            if (placeImages == null) {
                throw new NullPointerException("Image files array is null, check if directory is empty.");
            }

        } catch (IOException | NullPointerException e) {
            System.out.println("Directory or image loading failed: " + e.getMessage());
            return; // Exit if no valid path or empty directory
        }

        // Initialize and load images in the array
        touristSpotImages = new ImageIcon[placeImages.length];
        for (int i = 0; i < placeImages.length; i++) {
            String filePath = placeImages[i].getPath();
            try {
                ImageIcon tempImg = new ImageIcon(filePath);
                // Check to see if the image load is successful or not
                if (tempImg.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    throw new NullPointerException("Image failed to load at path: " + filePath);
                }
                touristSpotImages[i] = tempImg;
                System.out.printf("Image %2d loaded successfully from: %s%n", i, filePath);

            } catch (NullPointerException e) {
                System.out.println("Image loading failed for file " + filePath + ": " + e.getMessage());
            }
        }
    }

    public void initVehicleNames(){

        vehicleNames = new String[vhObjs.length];

        for(int i =0; i < vhObjs.length; i++){
            vehicleNames[i] = vhObjs[i].getVhName();
        }




    }
    private PlaceData() {
    }

    public void instanciateObjects(){
        initImages();
        initVehicleNames();
    }

    public static PlaceData getInstance() {

        if (pDInstance == null) {
            pDInstance = new PlaceData();
            pDInstance.instanciateObjects();


        }

        return pDInstance;
    }

    public Vehicle[] getVhArray(){
        return vhObjs;
    }

    public ImageIcon[] getTouristSpotImages() {
        return touristSpotImages;
    }

    public String[][] getTouristSpots() {
        return touristSpots;
    }

    public String[] getVehicleNames(){
        return vehicleNames;
    }

}
