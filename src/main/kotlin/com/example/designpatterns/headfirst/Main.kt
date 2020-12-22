package com.example.designpatterns.headfirst

fun main() {
    val weatherData = WeatherData()
    CurrentConditionsDisplay(weatherData)
    weatherData.registerObserver(StatisticsDisplay())
    val forecastDisplay = ForecastDisplay()
    weatherData.registerObserver(forecastDisplay)
    weatherData.setMeasurements(10f, 11f, 12f)
    weatherData.setMeasurements(5f, 5f, 5f)
    weatherData.removeObserver(forecastDisplay);
    weatherData.setMeasurements(62f, 90f, 28.1f)
}