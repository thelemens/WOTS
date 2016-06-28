import DataDump._
/**
  * Created by markk on 21/06/2016. */
object WarehouseUser {

  //view list of orders, view information of order
  def main(args: Array[String]) : Unit = {

    doUI(genOrderList())
    //    val emps = DataDump.getEmployees()
    //    val ords = DataDump.getOrders();DataDump.getProducts();
    //    for (order <- ords) {
    //      TextFormatter.printOrderInfo(order)
    //      TextFormatter.printOrderItems(order)
    //
    //    }
  }

  def genOrderList(): Orders = {
    DataDump.getOrders()
  }

  def doUI(list: Orders): Unit = {

    println("\n----------------------------\n")

    var run: Boolean = true
    do {
      println("\nEnter a command:\n1. View order list\n2. Edit Order Status\n9. Quit\n")
      val i = scala.io.StdIn.readInt()
      i match {
        case 1 => TextFormatter.printOrderList(list, 0); doOrderUI(list)

        case 2 => doOrderStatusUI(list)

        case 9 => run = false

        case whoops => println("Unexpected choice, try again")
      }
    } while (run)

    println("Exiting...")
  }

  def doOrderStatusUI(list: Orders): Unit = {

    var run: Boolean = true
    do {
      println("\n-------------------------\n")
      TextFormatter.printOrderStatuses(list, 0)
      println("----------------------\nChoose the number of an order to change status, or [0] to return to Main Menu")
      val c = scala.io.StdIn.readInt()
      val size = list.size
      if (c == 0) {
        run = false
      } else if (c <= size) {

        val item = list(c-1)

        println("\n-------------------------\n")
        println("Order " + item.oid + " status: " + item.status)
        println("\nSet New Status: [1] In Progress [2] Shipped [0] Cancel")
        val i = scala.io.StdIn.readInt()
        i match {
          case 1 => item.updateStatus(OrderStatus.Packing); println("Status changed to " + OrderStatus.Packing)

          case 2 => item.updateStatus(OrderStatus.Shipped); println("Status changed to " + OrderStatus.Shipped)

          case 0 => run = false

          case whoops => println("\nUnexpected choice, try again")
        }

      } else {
        //Catch the error TODO implement exception
        println("Please choose a valid number!!")
      }
    } while(run)
  }

  def doOrderUI(list: Orders): Unit = {

    var run: Boolean = true
    do {
      println("-----------\nChoose the number of an order for information, or [0] to return to Main Menu")
      val c = scala.io.StdIn.readInt()
      val size = list.size
      if (c == 0) {
        run = false
      } else if (c <= size) {
        TextFormatter.printOrderInfo(list(c-1))
      } else {
        //Catch the error TODO implement exception
        println("Please choose a valid number!!")
      }
    } while(run)
  }
}
