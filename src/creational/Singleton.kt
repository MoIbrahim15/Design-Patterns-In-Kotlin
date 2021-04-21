package creational

//The Singleton Pattern ensures a class has only one instance
//and provides a global point of access to it
//it may be difficult to unit testing because  it's tightly coupled which makes it hard to control the creation of it or mock it
object Singleton {
    var total = 0

    fun add(num: Int) {
        total += num
    }
}

class OtherClass {

    fun getSingletonTotal(): Int {
        return Singleton.total
    }
}

fun main() {
    Singleton.add(1)
    println("The answer of addition is ${Singleton.total}")            //1
    Singleton.add(9)
    println("The answer of addition is ${Singleton.total}")            //10
    Singleton.add(10)
    println("The answer of addition is ${Singleton.total}")            //20
    val otherClass = OtherClass()
    println("The answer of equals is ${otherClass.getSingletonTotal()}")      //20
}