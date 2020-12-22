package com.example.designpatterns.headfirst

class CurrentConditionsDisplay(
        weatherData: WeatherData,
        private var temp: Float = 0f,
        private var humidity: Float = 0f) : DisplayElement, Observer {

    init {
        weatherData.registerObserver(this)
    }

    override fun display() {
        println("CurrentConditions $temp F degrees and $humidity % humidity")
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temp = temp
        this.humidity = humidity
        display()
    }
}

class StatisticsDisplay(private var maxTemp: Float = 0.0f,
                        private var tempSum: Float = 0.0f,
                        private var numReadings: Int = 0,
                        private var minTemp: Float = 200f) : DisplayElement, Observer {


    override fun display() {
        println("Avg/Max/Min temperature = ${(tempSum.div(numReadings))}/$maxTemp/$minTemp");
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }
}


class ForecastDisplay(private var currentPressure: Float = 0f,
                      private var lastPressure: Float = 0f) : DisplayElement, Observer {


    override fun display() {
        print("Forecast: ")
        when {
            currentPressure > lastPressure -> {
                println("Improving weather on the way!")
            }
            lastPressure == currentPressure -> {
                println("More of the same")
            }
            currentPressure < lastPressure -> {
                println("Watch out for cooler, rainy weather")
            }
        }
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
}