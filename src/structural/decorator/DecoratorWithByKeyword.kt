package structural.decorator

data class User(val id: Int, val name: String, val email: String)

class UsersDecorator(private val items: MutableList<User> = mutableListOf()) : MutableList<User> by items {

    override fun add(element: User): Boolean {
        sendWelcomeEmail(element)
        return items.add(element)
    }

    override fun remove(element: User): Boolean {
        sendLogoutEmail(element)
        return items.add(element)
    }

    private fun sendWelcomeEmail(element: User) {
        println("Send Welcome Email to ${element.email}")
    }

    private fun sendLogoutEmail(element: User) {
        println("Send Logout Email to ${element.email}")
    }
}

fun main() {
    val user = User(1, "Mohamed", "abc@example.com")
    val usersWithEmailFeature = UsersDecorator(mutableListOf())
    usersWithEmailFeature.add(user)
    usersWithEmailFeature.remove(user)
}