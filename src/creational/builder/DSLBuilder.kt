package creational.builder

data class DialogDSL(
        private val _title: String?,
        private val _description: String?,
        private val _button: Button?) {
    fun show() {
        println("Title is $_title")
        println("Description is $_description")
        println("Button value is ${_button?.buttonValue}")
        _button?.buttonAction?.invoke()
    }
}

data class Button(val buttonValue: String?,
                  val buttonAction: (() -> Unit)?)

class DialogBuilder {
    var title: String? = null
    var description: String? = null
    var button: Button? = null

    fun title(lambda: () -> String) = apply { title = lambda() }
    fun description(lambda: () -> String) = apply { description = lambda() }
    fun button(lambda: ButtonBuilder.() -> Unit) {
        button = ButtonBuilder().apply(lambda).build()
    }

    fun build() = DialogDSL(title, description, button)
}

class ButtonBuilder {
    var value: String? = null
    var action: (() -> Unit)? = null

    fun value(lambda: () -> String) = apply { value = lambda() }
    fun action(lambda: () -> Unit) = apply { action = lambda }
    fun build() = Button(value, action)
}

fun dialog(lambda: DialogBuilder.() -> Unit) = DialogBuilder().apply(lambda).build()

fun main(args: Array<String>) {
    val dialog = dialog {
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
}

