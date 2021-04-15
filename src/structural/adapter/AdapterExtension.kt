package structural.adapter

interface UsbTypeC
interface UsbMini

//Extension fun.
fun UsbMini.toUsbTypeC() : UsbTypeC {
    return object : UsbTypeC {
        // Do something to convert
    }
}

fun main() {

}