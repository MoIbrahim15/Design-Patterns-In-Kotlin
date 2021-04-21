package creational

//The Factory Method Pattern defines an interface or abstract class for creating an object
//but let the subclasses decide which class to instantiate.
//In other words, subclasses are responsible to create the instance of the class.
//when you have object that can be added or, changed dynamically during runtime

abstract class Shape {
    abstract val shape: String

    fun draw() {
        println("Drawing a $shape...")
    }
}

class Square : Shape() {
    override val shape = "Square"
}

class Rectangle : Shape() {
    override val shape = "Rectangle"
}

interface IShapeFactory {
    fun createShape(shapeType: String?): Shape
}

class ShapeFactory : IShapeFactory {
    override fun createShape(shapeType: String?): Shape {
        return when (shapeType) {
            "s" -> Square()
            "r" -> Rectangle()
            else -> throw RuntimeException("Unknown shape $shapeType")
        }
    }
}

fun main() {
    println("Enter s for Square or R for Rectangle:")
    val shapeType = readLine()
    val shapeFactory: IShapeFactory = ShapeFactory()
    val shape = shapeFactory.createShape(shapeType)
    shape.draw()
}