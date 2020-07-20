package packt

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.BeforeAndAfter
import scala.collection.mutable

class ThirdExampleSpec
    extends AnyFlatSpec
    with BeforeAndAfter {
  val builder = new StringBuilder
  val buffer  = new mutable.ListBuffer[String]
  before {
    builder.append("ScalaTest is ")
  }
  after {
    builder.clear()
    buffer.clear()
  }

  "Testing" should "be easy" in {
    builder.append("easy!")
    assert(builder.toString === "ScalaTest is easy!")
    assert(buffer.isEmpty)
    buffer += "sweet"
  }

  it should "be fun" in {
    builder.append("fun!")
    assert(builder.toString === "ScalaTest is fun!")
    assert(buffer.isEmpty)
  }
}
