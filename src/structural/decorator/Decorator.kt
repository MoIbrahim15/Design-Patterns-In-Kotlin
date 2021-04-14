package structural.decorator


interface Pizza {
    fun description(): String
}

class SuperSupreme() : Pizza {
    override fun description() = "SuperSupreme Pizza"
}

class ChickenSupreme() : Pizza {
    override fun description() = "ChickenSupreme Pizza"
}

interface ToppingDecorator : Pizza {
    fun addTopping(): String
}

class JalapenoToppingDecorator(private val pizza: Pizza) : ToppingDecorator {
    override fun addTopping() = "With Jalapeno"
    override fun description() = pizza.description()
}

fun main(args: Array<String>) {
    JalapenoToppingDecorator(ChickenSupreme()).run {
        println("${this.description()}, ${this.addTopping()}")
    }

    JalapenoToppingDecorator(SuperSupreme()).run {
        println("${this.description()}, ${this.addTopping()}")
    }
}