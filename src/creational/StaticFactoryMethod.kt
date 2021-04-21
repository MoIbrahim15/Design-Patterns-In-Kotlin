package creational

//Static factory method is simply a static method that returns an instance of a class.
///Usually this method is inside a particular class.
class Numbers {
    companion object Parser {
        fun valueOf(number: Long): String {
            return number.toString()
        }
    }
}

fun main() {
    println(Numbers.valueOf(123))
}