package creational

//The Abstract Factory Pattern provides an interface for creating families of related
//or dependent objects without specifying their concrete classes.
//when you have many of objects that can be added or, changed dynamically during runtime

sealed class CarType(val value: String) {
    object MANUAL : CarType("MANUAL")
    object AUTOMATIC : CarType("AUTOMATIC")
}

sealed class TrainType(val value: String) {
    object GAS : TrainType("GAS")
    object ELECTRIC : TrainType("ELECTRIC")
}

sealed class Country(val value: String) {
    object EGYPT : Country("EGYPT")
    object USA : Country("USA")
}

abstract class Car(var country: Country, var carType: CarType) {
    fun build() {
        println("Made in:${country.value} Type:${carType.value}")
    }
}

class ManualCar(country: Country) : Car(country, CarType.MANUAL)

class AutomaticCar(country: Country) : Car(country, CarType.AUTOMATIC)

abstract class Train(var country: Country, var trainType: TrainType) {
    fun build() {
        println("Made in:${country.value} Type:${trainType.value}")
    }
}

class GasTrain(country: Country) : Train(country, TrainType.GAS)

class ElectricTrain(country: Country) : Train(country, TrainType.ELECTRIC)

interface Factory {
    fun buildCar(carType: CarType): Car
    fun buildTrain(trainType: TrainType): Train
}

class EgyptFactory : Factory {

    override fun buildCar(carType: CarType): Car {
        return when (carType) {
            CarType.MANUAL -> ManualCar(Country.EGYPT)
            CarType.AUTOMATIC -> AutomaticCar(Country.EGYPT)
        }
    }

    override fun buildTrain(trainType: TrainType): Train {
        return when (trainType) {
            TrainType.GAS -> GasTrain(Country.EGYPT)
            TrainType.ELECTRIC -> ElectricTrain(Country.EGYPT)
        }
    }
}

class USAFactory : Factory {
    override fun buildCar(carType: CarType): Car {
        return when (carType) {
            CarType.MANUAL -> ManualCar(Country.USA)
            CarType.AUTOMATIC -> AutomaticCar(Country.USA)
        }
    }

    override fun buildTrain(trainType: TrainType): Train {
        return when (trainType) {
            TrainType.GAS -> GasTrain(Country.USA)
            TrainType.ELECTRIC -> ElectricTrain(Country.USA)
        }
    }
}

interface ICountryFactory {
    fun getCountryFactory(country: Country): Factory
}

class CountryFactory : ICountryFactory {
    override fun getCountryFactory(country: Country): Factory {
        return when (country) {
            Country.EGYPT -> EgyptFactory()
            Country.USA -> USAFactory()
        }
    }
}

//country, carType and trainType should be dynamic from backend or user input as it could be created or changed at runtime
fun main() {
    val countryFactory: ICountryFactory = CountryFactory()
    val factory = countryFactory.getCountryFactory(Country.EGYPT)
    val car = factory.buildCar(CarType.AUTOMATIC)
    val train = factory.buildTrain(TrainType.ELECTRIC)
    car.build()
    train.build()
}