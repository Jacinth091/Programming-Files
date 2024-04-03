#include <stdio.h>
#include <stdlib.h>
#include <time.h>


typedef enum {

    Sunny =1,
    Cloudy,
    Rainy,
    Snowy,
    Windy,
    Stormy,


}WeatherCondi;

typedef struct {

    int weather;
    char cityName[50];
    float cityTemp, humidity;


}City;

int main(){

    srand(time(0));

    WeatherCondi weather = (rand() % 6) + 1;

    City cityOne;
    cityOne.weather = weather;

    switch (cityOne.weather) {
        case Sunny:
            printf("It's Currently, Sunny\n");
            break;
        case Cloudy:
            printf("It's Currently, Cloudy\n");
            break;
        case Rainy:
            printf("It's Currently, Rainy\n");
            break;
        case Snowy:
            printf("It's Currently, Snowy\n");
            break;
        case Windy:
            printf("It's Currently, Windy\n");
            break;
        case Stormy:
            printf("It's Currently, Stormy\n");
            break;
        default:
            printf("Unknown weather condition\n");
    }


    return 0;
}