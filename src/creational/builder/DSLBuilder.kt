package creational.builder

data class MaterialDialog(
        private val _title: String?,
        private val _description: String?,
        private val _button: Button?) {

    fun show() {
        println("Title is $_title")
        println("Description is $_description")
        println("Button value is ${_button?.buttonValue}")
    }

    fun click() {
        _button?.buttonAction?.invoke()
    }
}

data class Button(val buttonValue: String?,
                  val buttonAction: (() -> Unit)?)

class MaterialDialogBuilder {
    var title: String? = null
    var description: String? = null
    var button: Button? = null

    fun title(lambda: () -> String) = apply { title = lambda() }
    fun description(lambda: () -> String) = apply { description = lambda() }
    fun button(lambda: ButtonBuilder.() -> Unit) = apply { button = ButtonBuilder().apply(lambda).build() }
    fun build() = MaterialDialog(title, description, button)
}

class ButtonBuilder {
    var value: String? = null
    var action: (() -> Unit)? = null

    fun value(lambda: () -> String) = apply { value = lambda() }
    fun action(lambda: () -> Unit) = apply { action = lambda }
    fun build() = Button(value, action)
}

fun materialDialog(lambda: MaterialDialogBuilder.() -> Unit) = MaterialDialogBuilder().apply(lambda).build()

fun main() {
    val dialog = materialDialog {
        title { "Thanks" }
        description { "Your action is being processed" }
        button {
            value { "Ok" }
            action {
                println("Button clicked")
            }
        }
    }
    dialog.show()
    dialog.click()
}

