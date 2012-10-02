package net.srirangan
import org.scalatra._
import java.net.URL
import scalate.ScalateSupport
import stemmer.PorterStemmer
import stemmer.LanguageDetector

class MyScalatraFilter extends ScalatraFilter with ScalateSupport {
  
  override implicit val contentType = "text/html"
  
  get("/") {
    scaml("task1_1")
  }
  
  get("/task2and3") {
    scaml("task2and3")
  }
  
  post("/stem") {
	val input = params("msg")
	val words = input.split("\n").flatMap(getWordsFromLine).toList
	val language = LanguageDetector.checkLanguage(words)
    val stemmed = words.map(x => PorterStemmer.stem(x, language)).toList.mkString(" ")

	scaml("task2and3", "stemmed" -> stemmed, "language" -> language)
  }

  private val getWordsFromLine = (line: String) => {
    line.split(" ")
      .map(_.toLowerCase())
      .map(word => word.filter(Character.isLetter(_)))
      .filter(_.length() > 1)
      .toList
  }

  notFound {
    // If no route matches, then try to render a Scaml template
    val templateBase = requestPath match {
      case s if s.endsWith("/") => s + "index"
      case s => s
    }
    val templatePath = "/WEB-INF/scalate/templates/" + templateBase + ".scaml"
    servletContext.getResource(templatePath) match {
      case url: URL => 
        templateEngine.layout(templatePath)
      case _ => 
        filterChain.doFilter(request, response)
    } 
  }
}
