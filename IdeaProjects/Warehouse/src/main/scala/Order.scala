import OrderStatus._

import scala.collection.mutable.ArrayBuffer
/**
  * Created by markk on 21/06/2016.
  */
case class Order(oid : Int, eid : Int, cid : Int, var status : OrderStatus.Value, datePlaced: String, dateShipped: String) {

  //  def add(orderLine: OrderLine): Unit = {
  //    this.add(orderLine)
  //
  //}
  var orderLine =  ArrayBuffer[OrderLineItem]()

  def addOrderLineItem(item: OrderLineItem): Unit = {
    orderLine += item
  }

  def updateStatus(newStatus: OrderStatus.Value): Unit = {
    this.status = newStatus
  }

  Orders(this)
}

class Orders(val self: ArrayBuffer[Order]) extends Proxy {
  def ids = self map { _.oid }

  // ... other methods ...
}

object Orders {
  def apply(ord: Order*): Orders = ArrayBuffer(ord: _*)

  implicit def toOrders(b: ArrayBuffer[Order]): Orders = new Orders(b)

  implicit def toBuffer(ord: Orders): ArrayBuffer[Order] = ord.self
}