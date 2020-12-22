package com.example.designpatterns.headfirst

interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}

interface DisplayElement {
    fun display()
}