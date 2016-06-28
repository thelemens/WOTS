import scala.collection.mutable.ArrayBuffer

/**
  * Created by markk on 26/06/2016.
  */
object DataDump {

  def getOrders():  Orders = {

    val ol1 = OrderLineItem(1,2, false) //for order 1
    val ol2 = OrderLineItem(2, 1, true) //for order 2
    val ol3 = OrderLineItem(3, 1, true) //for order 2
    val ol4 = OrderLineItem(3, 2, true) // for order 3

    val order1 = Order(9071, 1, 1, OrderStatus.Ordered, "01012016", "0")
    val order2 = Order(9072, 1, 2, OrderStatus.Ordered, "02012016", "0")
    val order3 = Order(9073, 1, 2, OrderStatus.Ordered, "03012016", "0")

    order1.addOrderLineItem(ol1)
    order2.addOrderLineItem(ol2)
    order2.addOrderLineItem(ol3)
    order3.addOrderLineItem(ol4)

    Orders(order1,order2,order3)
  }

  def getEmployees() : Employees = {
    val uno = Employee(1, "Uno", "Oneton", "" )
    val dos = Employee(2, "Dos", "Sequelis", "" )
    val tres = Employee(3, "Trey", "Triplodocus", "" )

    Employees(uno,dos,tres)
  }

  def getProducts() : Products = {
    val p1 = Product(1, "Justin Bieber Gnome", "Garden Gnome", 12, 13.50, Location.Sector1, ProductStatus.Okay, "Small gnome with unusually small genitals")
    val p2 = Product(2, "Sexy Gnome", "Garden Gnome", 3, 17.99, Location.Sector2, ProductStatus.Okay, "Ceramic gnome in yellow polka-dot bikini")
    val p3 = Product(3, "Blue Balls", "Garden Accessories", 10, 5.99, Location.Sector3, ProductStatus.Okay, "Collection of blue balls")
    Products(p1)
  }


}
