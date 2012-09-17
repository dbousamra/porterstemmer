import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import stemmer.PorterStemmer
import org.scalatest.GivenWhenThen
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class Task1_2 extends FunSuite with ShouldMatchers with GivenWhenThen {

  //GENERALIZATION AND OSCILLATOR
  test("Oscillator behaves funny") {
    val result1 = PorterStemmer.EnglishStemming.oneStep("oscillator").toString
    val result2 = PorterStemmer.EnglishStemming.twoStep("oscillator").toString
    val result3 = PorterStemmer.EnglishStemming.threeStep("oscillator").toString
    val result4 = PorterStemmer.EnglishStemming.fourStep("oscillator").toString
    val result5 = PorterStemmer.EnglishStemming.fiveStep("oscillator").toString
    val result6 = PorterStemmer.EnglishStemming.sixStep("oscillator").toString
    println(result1 + " " + result2 + " " + result3 + " " + result4 + " " + result5 + " " + result6)
  }
  test("Generalization behaves funny") {
    val result1 = PorterStemmer.EnglishStemming.oneStep("generalization").toString
    val result2 = PorterStemmer.EnglishStemming.twoStep("generalization").toString
    val result3 = PorterStemmer.EnglishStemming.threeStep("generalization").toString
    val result4 = PorterStemmer.EnglishStemming.fourStep("generalization").toString
    val result5 = PorterStemmer.EnglishStemming.fiveStep("generalization").toString
    val result6 = PorterStemmer.EnglishStemming.sixStep("generalization").toString
    println(result1 + " " + result2 + " " + result3 + " " + result4 + " " + result5 + " " + result6)
  }

}