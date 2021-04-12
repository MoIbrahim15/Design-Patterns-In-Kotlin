package creational

sealed class OrderType {
    object TypeDelivery : OrderType()
    object TypePickUp : OrderType()
}

interface Order {
    fun extraCharges(): Int
}

class DeliveryOrder : Order {
    override fun extraCharges(): Int {
        return 5
    }
}

class PickUpOrder : Order {
    override fun extraCharges(): Int {
        return 0
    }
}

class OrderFactory {
    fun createOrder(orderType: OrderType): Order {
        return when (orderType) {
            OrderType.TypeDelivery -> DeliveryOrder()
            OrderType.TypePickUp -> PickUpOrder()
        }
    }
}

fun main(args: Array<String>) {
    val order = OrderFactory().createOrder(OrderType.TypeDelivery)
    println("Extra charges are ${order.extraCharges()}$") // 5$
}