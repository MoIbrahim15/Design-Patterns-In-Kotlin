package structural

interface Color {
    fun getColor(): String
}

class Red : Color {
    override fun getColor() = "Red"
}

class Blue : Color {
    override fun getColor() = "Blue"
}

interface Shape {
    fun getShape(): String
}

class Circle(private val color: Color) : Shape {
    override fun getShape() = "Circle -> ${color.getColor()}"
}

class Square(private val color: Color) : Shape {
    override fun getShape() = "Square -> ${color.getColor()}"
}

fun main() {
    val redCircle = Circle(Red())
    println(redCircle.getShape())
    val blueSquare = Square(Blue())
    println(blueSquare.getShape())
}