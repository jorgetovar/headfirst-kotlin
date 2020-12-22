package com.example.designpatterns.headfirst


class WeatherData(private var temp: Float = 0f,
                  private var humidity: Float = 0f,
                  private var pressure: Float = 0f,
                  private val observers: ArrayList<Observer> = ArrayList()) : Subject {


    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }


    override fun notifyObservers() {
        observers.forEach { it.update(temp, humidity, pressure) }
    }


    private fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temp: Float, humidity: Float, pressure: Float) {
        println("***** Update measurements *****")
        this.temp = temp
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

}