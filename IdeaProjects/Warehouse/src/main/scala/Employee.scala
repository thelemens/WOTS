import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Address
import scala.collection.mutable.ArrayBuffer

/**
  * Created by markk on 26/06/2016.
  */
case class Employee(eid: Int, firstName : String, lastName: String, address: String) {

  Employees(this)
}

class Employees(val self: ArrayBuffer[Employee]) extends Proxy {

  def eids = self map { _.eid }

  // ... other methods ...
}

object Employees {
  def apply(emp: Employee*): Employees = ArrayBuffer(emp: _*)

  implicit def toEmployees(b: ArrayBuffer[Employee]): Employees = new Employees(b)

  implicit def toBuffer(emp: Employees): ArrayBuffer[Employee] = emp.self
}