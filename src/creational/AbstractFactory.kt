package creational

sealed class CarType(val value: String) {
    object MINI : CarType("MINI")
    object LUXURY : CarType("LUXURY")
}

sealed class MadeInCountry(val value: String) {
    object EGYPT : MadeInCountry("EGYPT")
    object USA : MadeInCountry("USA")
}

interface Car {
    fun madeInCountry(): MadeInCountry
    fun carType(): CarType
}

class MiniCar(private val country: MadeInCountry) : Car {
    override fun madeInCountry(): MadeInCountry {
        return country
    }

    override fun carType(): CarType {
        return CarType.MINI
    }
}

class LuxuryCar(private val country: MadeInCountry) : Car {
    override fun madeInCountry(): MadeInCountry {
        return country
    }

    override fun carType(): CarType {
        return CarType.LUXURY
    }
}

class EgyptCarFactory {
    fun buildCar(carType: CarType): Car {
        return when (carType) {
            CarType.MINI -> MiniCar(MadeInCountry.EGYPT)
            CarType.LUXURY -> LuxuryCar(MadeInCountry.EGYPT)
        }
    }
}

class USACarFactory {
    fun buildCar(carType: CarType): Car {
        return when (carType) {
            CarType.MINI -> MiniCar(MadeInCountry.USA)
            CarType.LUXURY -> LuxuryCar(MadeInCountry.USA)
        }
    }
}

class CarFactory {
    fun buildCar(country: MadeInCountry, carType: CarType): Car {
        return when (country) {
            MadeInCountry.EGYPT -> EgyptCarFactory().buildCar(carType)
            MadeInCountry.USA -> USACarFactory().buildCar(carType)
        }
    }
}

fun main(args: Array<String>) {
    val car = CarFactory()
        .buildCar(MadeInCountry.EGYPT, CarType.LUXURY)
    println("Made in:${car.madeInCountry().value} Type:${car.carType().value}")
    // it prints Made in:EGYPT Type:LUXURY
}