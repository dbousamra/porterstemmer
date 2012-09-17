package regexstuff

object SentenceBreakDetector {
  
  def parse(input: String) = {
    val x = input.split("(?<=[.!?])\\s+")
    println(x.mkString(","))
    x
  }

}