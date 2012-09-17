import stemmer.PorterStemmer

object EnglishStemmerExample {
  
  private val getWordsFromLine = (line: String) => {
    line.split(" ")
      .map(_.toLowerCase())
      .map(word => word.filter(Character.isLetter(_)))
      .filter(_.length() > 1)
      .toList
  }

  def main(args: Array[String]) = {
    val inputText = """Then not to suffer this to fall to the ground, but rather to take it up, and to continue it in that state, 
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
  
   val words = inputText.split("\n").flatMap(getWordsFromLine).toList
   val stemmedWords = words.map(x => PorterStemmer.stem(x, "english")).toList
   val stemmedToRoot = (words zip stemmedWords).toMap
   println(stemmedToRoot.mkString("\n"))
  }
  

}