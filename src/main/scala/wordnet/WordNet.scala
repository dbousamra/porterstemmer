package wordnet

import edu.mit.jwi.IDictionary
import edu.mit.jwi.Dictionary
import java.io.File
import java.net.URL
import edu.mit.jwi.item.POS
import scala.collection.JavaConverters._
import edu.mit.jwi.item.IWordID
import edu.mit.jwi.item.Word
import edu.mit.jwi.item.Pointer

object WordNet extends App {

  def getSynonymGroups(word: String) = {
    val dict = new Dictionary(new File("src/main/scala/wordnet/dict"))
    dict.open();
    def getWord(word: String) = {
      val wordId = dict.getIndexWord(word, POS.NOUN)
      if (wordId == null) {
        None
      } else {
        Some(wordId)
      }
    }

    val wordId = getWord(word)
    wordId match {
      case Some(wordId) => {
        val synonymIds = wordId.getWordIDs().asScala.map(wid => dict.getWord(wid))
        val words = synonymIds.map { w => w.getSynset().getWords() }
        words.map(wordList => wordList.asScala.toList.filter(w => w.getLemma() != word)).toList.filterNot(l => l.isEmpty)
      }
      case None => Nil
    }
  }
  
  def getHyponyms(word: String) = {
    val dict = new Dictionary(new File("src/main/scala/wordnet/dict"))
    dict.open();
    def getWord(word: String) = {
      val wordId = dict.getIndexWord(word, POS.NOUN)
      if (wordId == null) {
        None
      } else {
        Some(wordId)
      }
    }
    val wordId = getWord(word)
    wordId match {
      case Some(wordId) => {
        val synonymIds = wordId.getWordIDs().asScala.map(wid => dict.getWord(wid))
        val synsets = synonymIds.map { w => w.getSynset().getRelatedSynsets(Pointer.HYPERNYM) }
        
        
        synsets.map(sidList => sidList.asScala.map(dict.getSynset(_).getWords().asScala.toList)).flatten.toList
        
//        words.map(wordList => wordList.asScala.toList.filter(w => w.getLemma() != word)).toList.filterNot(l => l.isEmpty)
      }
      case None => Nil
    }
  }
  
  println(getHyponyms("boxer").mkString("\n"))

}