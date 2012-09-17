import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import stemmer.PorterStemmer
import org.scalatest.GivenWhenThen
import org.scalatest.FunSuite
import stemmer.LanguageDetector

@RunWith(classOf[JUnitRunner])
class Task3 extends FunSuite with ShouldMatchers with GivenWhenThen {

  private val getWordsFromLine = (line: String) => {
    line.split(" ")
      .map(_.toLowerCase())
      .map(word => word.filter(c => Character.isLetter(c) || c == "'".toCharArray()(0)))
      .filter(_.length() > 1)
      .toList
  }
  
  val englishText = """Then not to suffer this to fall to the ground, but rather to take it up, and to continue it in that state, 
      wherein the famous Predecessor of Your Highness did leave it: nay, to go forward with the confidence and resolution of a Man 
      in maintaining the truth of Christ, and propagating it far and near, is that which hath so bound and firmly knit the hearts
      of all Your Majesty's loyal and religious people unto You, that Your very name is precious among them: their eye doth behold 
      You with comfort, and they bless You in their hearts, as that sanctified Person, who, under God, is the immediate Author of
      their true happiness. And this their contentment doth not diminish or decay, but every day increaseth and taketh strength, 
      when they observe, that the zeal of Your Majesty toward the house of God doth not slack or go backward, but is more and 
      more kindled, manifesting itself abroad in the farthest parts of [Christendom], by writing in defence of the Truth, (which hath
      given such a blow unto that man of Sin, as will not be healed,) and every day at home, by religious and learned discourse, by 
      frequenting the house of God, by hearing the Word preached, by cherishing the Teachers thereof, by caring for the Church, as a 
      most tender and loving nursing Father."""

  val frenchText = """Le premier lundi du mois d'avril 1625, le bourg de Meung, où naquit l'auteur du 
    Roman de la Rose, semblait être dans une révolution aussi entière que si les huguenots 
    en fussent venus faire une seconde Rochelle. Plusieurs bourgeois, voyant s'enfuir les 
    femmes du côté de la Grand-Rue, entendant les enfants crier sur le seuil des portes, 
    se hâtaient d'endosser la cuirasse, et, appuyant leur contenance quelque peu incertaine 
    d'un mousquet ou d'une pertuisane, se dirigeaient vers l'Hôtellerie du Franc-Meunier, 
    devant laquelle s'empressait, en grossissant de minute en minute, un groupe compact, 
    bruyant et plein de curiosité. 
    
    En ce temps-là les paniques étaient fréquentes, et peu de jours se passaient sans qu'une ville 
    ou l'autre enregistrât sur ses archives quelque événement de ce genre. Il y avait les seigneurs 
    qui guerroyaient entre eux ; il y avait le roi qui faisait la guerre au cardinal ; il y avait 
    l'Espagnol qui faisait la guerre au roi. Puis, outre ces guerres sourdes ou publiques, secrètes 
    ou patentes, il y avait encore les voleurs, les mendiants, les huguenots, les loups et les laquais, 
    qui faisaient la guerre à tout le monde. Les bourgeois s'armaient toujours contre les voleurs, 
    contre les loups, contre les laquais ; souvent contre les seigneurs et les huguenots ; quelquefois 
    contre le roi ; mais jamais contre le cardinal et l'Espagnol. Il résulta donc de cette habitude 
    prise que, ce susdit premier lundi du mois d'avril 1625, les bourgeois, entendant du bruit, et ne 
    voyant ni le guidon jaune et rouge, ni la livrée du duc de Richelieu, se précipitèrent du côté 
    de l'Hôtel du Franc-Meunier. """
  
  //GENERALIZATION AND OSCILLATOR
  test("French text should be detected as French") {
    val frenchWords = frenchText.split("\n").flatMap(getWordsFromLine).toList
    val language = LanguageDetector.checkLanguage(frenchWords)
    language should equal("french")
  }
  
  test("English text should be detected as English") {
    val englishWords = englishText.split("\n").flatMap(getWordsFromLine).toList
    val language = LanguageDetector.checkLanguage(englishWords)
    language should equal("english")
  }

}
