package net.srirangan
import org.scalatra._
import java.net.URL
import scalate.ScalateSupport

class MyScalatraFilter extends ScalatraFilter with ScalateSupport {
  
  override implicit val contentType = "text/html"
  
  get("/") {
    jade("hello-scalate")
  }

  notFound {
    // If no route matches, then try to render a Scaml template
    val templateBase = requestPath match {
      case s if s.endsWith("/") => s + "index"
      case s => s
    }
    val templatePath = "/WEB-INF/scalate/templates/" + templateBase + ".ssp"
    servletContext.getResource(templatePath) match {
      case url: URL => 
        templateEngine.layout(templatePath)
      case _ => 
        filterChain.doFilter(request, response)
    } 
  }
}
