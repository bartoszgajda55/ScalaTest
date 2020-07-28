package packt

import org.scalatest.Succeeded
import org.scalacheck.Gen

class GeneratorsSepc extends UnitSpec {
  "a test" should "succeed" in {
    val strings = (for {
      s1 <- Gen.alphaStr
      s2 <- Gen.alphaStr
    } yield (s1, s2)).suchThat(m =>
      m._2.length > m._1.length * 2
    )

    val vowel =
      Gen.oneOf[Char]('A', 'E', 'I', 'O', 'U', 'Y')

    val vowel2 = Gen.frequency(
      (3, 'A'),
      (4, 'E'),
      (2, 'I'),
      (3, 'O'),
      (1, 'U'),
      (1, 'Y')
    )

    val primes = for {
      s1 <-
        Gen
          .chooseNum(10, 100)
          .suchThat(n =>
            !((2 until n / 2)
              exists (n % _ == 0))
          )
    } yield s1

    val genIntList =
      Gen.containerOf[List, Int](Gen.oneOf(4, 6, 7))

    Succeeded
  }
}
