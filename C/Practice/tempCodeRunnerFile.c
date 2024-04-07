    // Sunny Conditions
        if((cityData[i].fahren > 70) && (cityData[i].humid >= 30 && cityData[i].humid <= 60)){
            weather = Sunny;
        }// Cloudy / Partly Cloudy
        else if((cityData[i].fahren >= 50 && cityData[i].fahren <= 80) && (cityData[i].humid >= 50 && cityData[i].humid <= 80)){
            weather = Cloudy;
        }// Rainy
        else if((cityData[i].fahren >= 45 && cityData[i].fahren <= 75) && (cityData[i].humid >= 60 && cityData[i].humid <= 100)){
            weather = Rainy;
        }// Snowy
        else if((cityData[i].fahren >= 20 && cityData[i].fahren <= -20) && (cityData[i].humid >= 20 && cityData[i].humid <= 80)){
            weather = Snowy;
        }// Windy
        else if((cityData[i].fahren > 50) && (cityData[i].humid >= 30 && cityData[i].humid <= 60)){
            weather = Windy;
        }// Stormy
        else if((cityData[i].fahren > 60) && (cityData[i].humid >= 70 && cityData[i].humid <= 100)){
            weather = Stormy;

        }
        else if((cityData[i].fahren >= 50 && cityData[i].fahren <= 80) && (cityData[i].humid >= 30 && cityData[i].humid <= 60)){
            weather = Clear;
        }
        else if((cityData[i].fahren > 100)){
            weather = Extreme;
        }
        cityData[i].weather = weather;