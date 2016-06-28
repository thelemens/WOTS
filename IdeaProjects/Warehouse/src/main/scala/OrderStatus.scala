/**
  * Created by markk on 26/06/2016.
  */
object OrderStatus extends Enumeration {

  val Ordered, Packing, Shipped = Value

  //  case object POStatus {
  //    val Ordered,Delivered = Value
  //  }
  //
  //  object OrderStatus{
  //    val Ordered, Packing, Shipped = Value
  //  }
  //
  //  object productStatus {
  //
  //    val Okay, Damaged = Value
  //  }
}

object ProductStatus extends Enumeration {
  val Okay, Damaged = Value

  def set(): Unit = {
    //Value =
  }
}
