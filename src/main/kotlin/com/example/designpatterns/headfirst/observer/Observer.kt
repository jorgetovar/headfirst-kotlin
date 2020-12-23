package com.example.designpatterns.headfirst.observer

fun main() {
    val weatherData = WeatherData()
    CurrentConditionsDisplay(weatherData)
    StatisticsDisplay(weatherData)
    val forecastDisplay = ForecastDisplay(weatherData)

    weatherData.setMeasurements(10f, 11f, 12f)
    weatherData.setMeasurements(5f, 5f, 5f)
    weatherData.removeObserver(forecastDisplay);
    weatherData.setMeasurements(62f, 90f, 28.1f)
}