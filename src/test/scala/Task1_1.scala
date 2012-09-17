import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import stemmer.PorterStemmer
import org.scalatest.GivenWhenThen
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class Task1_1 extends FunSuite with ShouldMatchers with GivenWhenThen {

  //FALSE POSITIVES

  implicit val language = "english"
  
  test("Organization should not stem to the same as organ") {
    PorterStemmer("organization") should not equal PorterStemmer("organ")
  }

  test("Generalization should not stem to the same as generic") {
    PorterStemmer("generalization") should not equal PorterStemmer("generic")
  }

  test("Numerical should not stem to the same as numerous") {
    PorterStemmer("numerical") should not equal PorterStemmer("numerous")
  }

  test("University should not stem to the same as universe") {
    PorterStemmer("university") should not equal PorterStemmer("universe")
  }

  test("Addition should not stem to the same as additive") {
    PorterStemmer("addition") should not equal PorterStemmer("additive")
  }

  test("Negligible should not stem to the same as negligent") {
    PorterStemmer("negligible") should not equal PorterStemmer("negligent")
  }

  //FALSE NEGATIVES

  test("European should stem to the same as europe") {
    PorterStemmer("european") should equal(PorterStemmer("europe"))
  }

  test("Cylinder should stem to the same as cylindrical") {
    PorterStemmer("cylinder") should equal(PorterStemmer("cylindrical"))
  }

  test("Matrices should stem to the same as matrix") {
    PorterStemmer("matrices") should equal(PorterStemmer("matrix"))
  }

  test("Urgency should stem to the same as urgent") {
    PorterStemmer("urgency") should equal(PorterStemmer("urgent"))
  }

  test("Create should stem to the same as creation") {
    PorterStemmer("create") should equal(PorterStemmer("creation"))
  }

  test("Analysis should stem to the same as analyses") {
    PorterStemmer("analysis") should equal(PorterStemmer("analyses"))
  }

}