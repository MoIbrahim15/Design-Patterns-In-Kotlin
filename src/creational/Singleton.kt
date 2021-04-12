package creational

fun main(args: Array<String>) {
    println("The answer of addition is ${Singleton.add(1)}")            //1
    println("The answer of addition is ${Singleton.add(9)}")            //10
    println("The answer of addition is ${Singleton.add(10)}")           //20
    println("The answer of equals is ${OtherClass().getResult()}")      //20
}

class OtherClass {
    fun getResult(): Int {
        return Singleton.result
    }
}

object Singleton {
    var result = 0
    fun add(num: Int): Int {
        result += num
        return result
    }
}