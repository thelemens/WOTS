/**
  * Created by markk on 21/06/2016.
  */
import Location._

import scala.collection.mutable.ArrayBuffer

case class Product(pid: Int, name : String, productType : String, var stock : Int, var price : Double, location : Location, var status : ProductStatus.Value, desc: String) {
  var damQuantity: Int = _

  def updateStock(amount: Int){
    stock += amount
  }

  //  def withId(id: Int): Product {
  //
  //  }

  def setDamaged(discountPrice : Double, quantity: Int, damageDescription: String): Unit = {
    status = ProductStatus.Damaged
    price = discountPrice
    stock -= quantity
    damQuantity = quantity
  }
}

class Products(val self: ArrayBuffer[Product]) extends Proxy {
  def pids = self map { _.pid }

  // ... other methods ...
}

object Products {
  def apply(prod: Product*): Products = ArrayBuffer(prod: _*)

  implicit def toProducts(b: ArrayBuffer[Product]): Products = new Products(b)

  implicit def toBuffer(prod: Products): ArrayBuffer[Product] = prod.self
}