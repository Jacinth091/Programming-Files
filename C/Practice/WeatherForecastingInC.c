#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <strings.h>


typedef enum {
    // Unknown,
    Sunny =1,
    Cloudy,
    Rainy,
    Snowy,
    Windy,
    Stormy,
    Clear,
    Extreme,


}WeatherCondi;

typedef struct {

    int weather;
    char cityName[50];
    int humid;
    float fahren, celsi;



}City;

void cityDataList(City *cityData, int length, char *city[]);

int main(){

    char *city[] = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", 
                    "San Antonio", "San Diego", "Dallas", "San Jose"};
    const int numToForecast =10;
    City cityData[numToForecast];
    
    cityDataList(cityData, numToForecast, city);
    
    printf("\n\n"); 
    printf("%5s  \t %5s  \t %5s \t %5s\n", "Fahrenheit", "Celsius", "Humidty", "Weather"); 
    for(int i =0; i < numToForecast; i++){
        printf(" %5.1f F \t %5.1f C \t %5.d %% \t %5d\n", cityData[i].fahren, cityData[i].celsi,cityData[i].humid, cityData[i].weather);

    }
    

    return 0;
}



void cityDataList(City *cityData, int length, char *city[]){

    int rando =0, counter =10;
    int minTemp = -200, maxTemp = 1200;
    WeatherCondi weather;
    srand(time(NULL));

    for(int i = 0; i < length; i++){

        strcpy(cityData[i].cityName, city[i]);
        cityData[i].fahren =(float) (rand() % (maxTemp - minTemp + 1) + minTemp) / 10.0;
        cityData[i].celsi = ((cityData[i].fahren - 32) * 5) / 9;
        cityData[i].humid = rand() % (100 - 10 + 1) + 10;
        cityData[i].weather = 0;

        // Revise the Conditions for the Weather Conditions 

        // // Sunny Conditions
        // if((cityData[i].fahren > 70) && (cityData[i].humid >= 30 && cityData[i].humid <= 60)){
        //     weather = Sunny;
        // }// Cloudy / Partly Cloudy
        // else if((cityData[i].fahren >= 50 && cityData[i].fahren <= 80) && (cityData[i].humid >= 50 && cityData[i].humid <= 80)){
        //     weather = Cloudy;
        // }// Rainy
        // else if((cityData[i].fahren >= 45 && cityData[i].fahren <= 75) && (cityData[i].humid >= 60 && cityData[i].humid <= 100)){
        //     weather = Rainy;
        // }// Snowy
        // else if((cityData[i].fahren >= 20 && cityData[i].fahren <= -20) && (cityData[i].humid >= 20 && cityData[i].humid <= 80)){
        //     weather = Snowy;
        // }// Windy
        // else if((cityData[i].fahren > 50) && (cityData[i].humid >= 30 && cityData[i].humid <= 60)){
        //     weather = Windy;
        // }// Stormy
        // else if((cityData[i].fahren > 60) && (cityData[i].humid >= 70 && cityData[i].humid <= 100)){
        //     weather = Stormy;

        // }
        // else if((cityData[i].fahren >= 50 && cityData[i].fahren <= 80) && (cityData[i].humid >= 30 && cityData[i].humid <= 60)){
        //     weather = Clear;
        // }
        // else if((cityData[i].fahren > 100)){
        //     weather = Extreme;
        // }
        // cityData[i].weather = weather;


    }



}
