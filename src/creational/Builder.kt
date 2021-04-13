package creational

class Dialog private constructor(
        private val _title: String?,
        private val _description: String?,
        private val _buttonValue: String?,
        private val _buttonAction: (() -> Unit)?) {

    data class Builder(
            var title: String? = null,
            var description: String? = null,
            var buttonValue: String? = null,
            var buttonAction: (() -> Unit)? = null) {

        fun title(title: String) = apply { this.title = title }
        fun description(description: String) = apply { this.description = description }
        fun buttonValue(buttonValue: String) = apply { this.buttonValue = buttonValue }
        fun buttonAction(buttonAction: () -> Unit) = apply { this.buttonAction = buttonAction }
        fun build() = Dialog(title, description, buttonValue, buttonAction)
    }

    fun show() {
        println("Title is $_title")
        println("Description is $_description")
        println("Button value is $_buttonValue")
        _buttonAction?.invoke()
    }
}

fun main(args: Array<String>) {

    val dialog = Dialog.Builder()
            .title("Thanks")
            .description("Your action is being processed")
            .buttonValue("Ok")
            .buttonAction { println("Button clicked") }
            .build()
    dialog.show()
}