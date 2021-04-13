package creational

data class Email(var to: String, var cc: MutableList<String>?, var title: String?, var msg: String?)

fun main(args: Array<String>) {
    val mail = Email("a@example.com", mutableListOf(), "Title", "Message")
    val copy = mail.copy(to = "b@example.com")

    println("Email to ${mail.to} with title: ${mail.title}")
    println("Copied Email to ${copy.to} with title: ${copy.title}")
}