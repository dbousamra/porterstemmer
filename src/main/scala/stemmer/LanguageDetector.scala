package stemmer

import scala.io.Source
import java.io.File

object LanguageDetector {

  private val getWordsFromLine = (line: String) => {
    line.split(" ")
      .map(_.toLowerCase())
      .map(word => word.filter(Character.isLetter(_)))
      .filter(_.length() > 1)
      .toList
  }

  
  
  def checkLanguage(lines: List[String]):String = {
    val englishStopWords = Source.fromFile(new File("src/main/scala/stemmer/englishStopWords.txt")).getLines.toList
    val frenchStopWords = Source.fromFile(new File("src/main/scala/stemmer/frenchStopWords.txt")).getLines.toList
    val words = lines.flatMap(getWordsFromLine)
    val englishScore = englishStopWords.foldLeft(0){(count, word) => count + getCountOfWord(words, word) }
    val frenchScore = frenchStopWords.foldLeft(0){(count, word) => count + getCountOfWord(words, word) }
    if (englishScore > frenchScore) "English" else "French"
  }
  
  def getCountOfWord(words: List[String], word: String) = {
    words.count(_ == word)
  }

}