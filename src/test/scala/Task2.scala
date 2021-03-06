import stemmer.PorterStemmer

object FrenchStemmerExample {

  private val getWordsFromLine = (line: String) => {
    line.split(" ")
      .map(_.toLowerCase())
      .map(word => word.filter(c => Character.isLetter(c) || c == "'".toCharArray()(0)))
      .filter(_.length() > 1)
      .toList
  }

  val inputText = """Le premier lundi du mois d'avril 1625, le bourg de Meung, o� naquit l'auteur du 
    Roman de la Rose, semblait �tre dans une r�volution aussi enti�re que si les huguenots 
    en fussent venus faire une seconde Rochelle. Plusieurs bourgeois, voyant s'enfuir les 
    femmes du c�t� de la Grand-Rue, entendant les enfants crier sur le seuil des portes, 
    se h�taient d'endosser la cuirasse, et, appuyant leur contenance quelque peu incertaine 
    d'un mousquet ou d'une pertuisane, se dirigeaient vers l'H�tellerie du Franc-Meunier, 
    devant laquelle s'empressait, en grossissant de minute en minute, un groupe compact, 
    bruyant et plein de curiosit�. 
    
    En ce temps-l� les paniques �taient fr�quentes, et peu de jours se passaient sans qu'une ville 
    ou l'autre enregistr�t sur ses archives quelque �v�nement de ce genre. Il y avait les seigneurs 
    qui guerroyaient entre eux ; il y avait le roi qui faisait la guerre au cardinal ; il y avait 
    l'Espagnol qui faisait la guerre au roi. Puis, outre ces guerres sourdes ou publiques, secr�tes 
    ou patentes, il y avait encore les voleurs, les mendiants, les huguenots, les loups et les laquais, 
    qui faisaient la guerre � tout le monde. Les bourgeois s'armaient toujours contre les voleurs, 
    contre les loups, contre les laquais ; souvent contre les seigneurs et les huguenots ; quelquefois 
    contre le roi ; mais jamais contre le cardinal et l'Espagnol. Il r�sulta donc de cette habitude 
    prise que, ce susdit premier lundi du mois d'avril 1625, les bourgeois, entendant du bruit, et ne 
    voyant ni le guidon jaune et rouge, ni la livr�e du duc de Richelieu, se pr�cipit�rent du c�t� 
    de l'H�tel du Franc-Meunier. """

  def main(args: Array[String]) = {
    val words = inputText.split("\n").flatMap(getWordsFromLine).toList
    val stemmedWords = words.map(x => PorterStemmer.stem(x, "french")).toList
    val stemmedToRoot = (words zip stemmedWords).toMap
    stemmedToRoot.foreach {
      case (key, value) => if (key != value) {
        println("WORD CHANGED " + key + " " + value)
      }
    }
    println()
    stemmedToRoot.foreach {
      case (key, value) => if (key != value) {
        println(value)
      }
    }
    println(stemmedToRoot.mkString("\n"))
  }
}