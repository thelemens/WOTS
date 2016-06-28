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

  //  def printList(list: Orders): Unit ={
  //    //print list of orders  CHANGE THIS TO CONTROL ITEMS?
  //    var i: Int = 0
  //    for (item <- list) {
  //      i += 1
  //      println(i + ". " + item)
  //    }
  //  }

  def doUI(list: Orders): Unit = {

    println("\n----------------------------\n")

    var run: Boolean = true
    do {
      println("\nEnter a command:\n1. View order list\n2. Quit\n")
      val i = scala.io.StdIn.readInt()
      i match {
        case 1 => TextFormatter.printOrderList(list, 0); doOrderUI(list)
        case 2 => /* println("Existing"); */ run = false
        case whoops => println("Unexpected choice, try again")
      }
    } while (run)

    println("Exiting...")
  }

  def doOrderUI(list: Orders): Unit = {

    var run: Boolean = true
    do {
      println("-----------\nChoose the number of an order for information, or [0] to exit")
      val c = scala.io.StdIn.readInt()
      val size = list.size
      if (c == 0) {
        run = false
      } else if (c <= size) {
        TextFormatter.printOrderInfo(list(c))
      } else {
        //Catch the error TODO implement exception
        println("PLease choose a valid number!!")
      }
    } while(run)
  }
}
