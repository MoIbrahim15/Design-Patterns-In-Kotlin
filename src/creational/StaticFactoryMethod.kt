package creational

fun main(args : Array<String>) {
    println(Numbers.valueOf("123"))
}

class Numbers {
    companion object Parser {
        fun valueOf(number: String) : Long {
            return number.toLong()
        }
    }
}
