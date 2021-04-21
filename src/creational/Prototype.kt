package creational


//The Prototype Pattern allows you to make new instances by copying existing instances
//Use the Prototype Pattern when creating an instance of a given class is either expensive or complicated.
//it all about customization and creating objects that are very similar
data class Email(var to: String, var cc: MutableList<String>?, var title: String?, var msg: String?)

fun main() {
    val mail = Email("a@example.com", mutableListOf(), "Hello", "I hope this Email finds you well")
    println("Email to ${mail.to} with title: ${mail.title}")

    val copy = mail.copy(to = "b@example.com")
    println("Copied Email to ${copy.to} with title: ${copy.title}")
}