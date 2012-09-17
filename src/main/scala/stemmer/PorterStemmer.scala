package stemmer

import Util._
import scalaz._

object PorterStemmer {
  import stemmer.Util

  def apply(word: String)(implicit language: String) = {
    val x = stem(word, language)
    x
  }

  def stem(word: String,  language: String): String = {
    language match {
      case "english" => EnglishStemming.sixStep(word).toString
      case "french" => FrenchStemming.stemWord(word).toString
      case _ => ""
    }

  }

  object FrenchStemming {

    val stemWord = (step1 _)

    def step1(word: String): Word = {
      var stem = new Word(word)
      if (stem matchedBy ("x")) {

        if (stem matchedBy ("aux")) {
          stem = stem.applyReplaces(
            "aux" -> "al")
        } else {
          stem = stem.applyReplaces(m > 5)("x" -> "")
        }
      } else {
        stem = stem.applyReplaces(m > 5)("s" -> "")
        stem = stem.applyReplaces(m > 5)("r" -> "")
        stem = stem.applyReplaces(m > 5)("e" -> "")
        stem = stem.applyReplaces(m > 5)("Ž" -> "")

      }
      stem = stem.applyReplaces("ent" -> "")
      stem = stem.applyReplaces("es" -> "e")
      stem = stem.applyReplaces("s" -> "")
      stem
    }

  }

  object EnglishStemming {

    def oneStep   = step1 _
    def twoStep   = (step1 _ andThen step2)
    def threeStep = (step1 _ andThen step2 andThen step3)
    def fourStep  = (step1 _ andThen step2 andThen step3 andThen step4)
    def fiveStep  = (step1 _ andThen step2 andThen step3 andThen step4 andThen step5a)
    def sixStep   = (step1 _ andThen step2 andThen step3 andThen step4 andThen step5a andThen step5b)

    
    def step1(word: String): Word = {
      var stem = new Word(word).applyReplaces(
        "sses" -> "ss",
        "ies" -> "i",
        "ss" -> "ss",
        "s" -> "")

      if ((stem matchedBy ((~v~) + "ed")) ||
        (stem matchedBy ((~v~) + "ing"))) {

        stem = stem.applyReplaces(~v~)("ed" -> "", "ing" -> "")

        stem = stem.applyReplaces(
          "at" -> "ate",
          "bl" -> "ble",
          "iz" -> "ize",
          (~d and not(~L or ~S or ~Z)) -> singleLetter,
          (m == 1 and ~o) -> "e")
      } else {
        stem = stem.applyReplaces((m > 0) + "eed" -> "ee")
      }

      stem = stem.applyReplaces((~v~) + "y" -> "i")
      stem
    }

    val step2 = (stem: Word) => {
      stem.applyReplaces(m > 0)(
        "ational" -> "ate",
        "tional" -> "tion",
        "enci" -> "ence",
        "anci" -> "ance",
        "izer" -> "ize",
        "abli" -> "able",
        "alli" -> "al",
        "entli" -> "ent",
        "eli" -> "e",
        "ousli" -> "ous",
        "ization" -> "ize",
        "ation" -> "ate",
        "ator" -> "ate",
        "alism" -> "al",
        "iveness" -> "ive",
        "fulness" -> "ful",
        "ousness" -> "ous",
        "aliti" -> "al",
        "iviti" -> "ive",
        "biliti" -> "ble")
    }

    val step3 = (stem: Word) => {
      stem.applyReplaces(m > 0)(
        "icate" -> "ic",
        "ative" -> "",
        "alize" -> "al",
        "iciti" -> "ic",
        "ical" -> "ic",
        "ful" -> "",
        "ness" -> "")
    }

    val step4 = (stem: Word) => {
      stem.applyReplaces(m > 1)(
        "al" -> "",
        "ance" -> "",
        "ence" -> "",
        "er" -> "",
        "ic" -> "",
        "able" -> "",
        "ible" -> "",
        "ant" -> "",
        "ement" -> "",
        "ment" -> "",
        "ent" -> "",
        (~S or ~T) + "ion" -> "",
        "ou" -> "",
        "ism" -> "",
        "ate" -> "",
        "iti" -> "",
        "ous" -> "",
        "ive" -> "",
        "ize" -> "")
    }

    val step5a = (stem: Word) => {
      stem applyReplaces ((m > 1) + "e" -> "",
        ((m == 1) and not(~o)) + "e" -> "")
    }

    val step5b = (stem: Word) => {
      stem applyReplaces ((m > 1 and ~d and ~L) -> singleLetter)
    }
  }

}