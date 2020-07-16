import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec

class PacktSpec extends AnyFlatSpec with Matchers {
  "a test" should "succeed" in {
    val message = "abc"

    message should be ("abc")
    message shouldBe "abc"
    message should equal ("abc")
    message should === ("abc")
    message shouldEqual "abc"

    message shouldBe a [String]
  }

  it should "pass" in {
    val message = "abc"

    message should have length 3

    message should startWith ("a")
    message should endWith ("c")
    message shouldNot include ("d")
  }

  it should "conquer" in {
    val voltage = 10

    voltage shouldEqual (11 +- 2)

    Some(1) should not be empty
  }

  it should "win" in {
    (List("John", "Bob", "Alice") should contain ("Alice"))
    List(1, 2, 3, 4, 5) should contain oneOf (5, 7, 9)
    List(1, 2, 3, 4, 5) should contain noneOf (7, 8, 9)

    List(1, 2, 2, 3, 3, 3) should contain inOrderOnly (1, 2, 3)

    val xs = List(1, 2, 3)
    all (xs) should be < 10
  }

  it should "fail" in {
    "val a: String = 1" shouldNot compile
    "val a: String = 1" shouldNot typeCheck
  }
}
