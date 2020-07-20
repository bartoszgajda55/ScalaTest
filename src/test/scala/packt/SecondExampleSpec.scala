package packt

import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable

class SecondExampleSpec extends AnyFlatSpec {
  trait Builder {
    val builder = new StringBuilder("ScalaTest is ")
  }

  trait Buffer {
    val buffer = mutable.ListBuffer("ScalaTest", "is")
  }

  "Testing" should "be productive" in new Builder {
    builder.append("productive!")
    assert(builder.toString === "ScalaTest is productive!")
  }

  "Test code" should "be readable" in new Buffer {
    buffer += ("readable!")
    assert(buffer === List("ScalaTest", "is", "readable!"))
  }

  it should "be clear and concise" in new Builder
    with Buffer {
    builder.append("clear!")
    buffer += ("concise!")
    assert(builder.toString === "ScalaTest is clear!")
    assert(buffer === List("ScalaTest", "is", "concise!"))
  }

}
