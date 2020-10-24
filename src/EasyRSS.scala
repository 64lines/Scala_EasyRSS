import java.net.URL
import java.util.Date

import com.rometools.rome.feed.synd.{SyndEntry, SyndFeed}
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader

import scala.collection.JavaConverters.{asScala, _}

object EasyRSS {
  class RSSEntry(var title: String, var uri: String, var date: Date,
                 var link: String, var content: String, var category: String) {
    override def toString(): String =
      s"Title: $title\nURI: $uri\nDate: $date\nLink: $link\nContent: $content\nCategory:$category\n\n"
  }

  def buildFeedInput(url: URL): SyndFeed = new SyndFeedInput().build(getXmlReader(url))
  def getUrl(url: String) = new URL(url)
  def getXmlReader(url: URL) = new XmlReader(url)
  def getVectorEntries(feedUrl: URL): Vector[SyndEntry] = asScala(buildFeedInput(feedUrl).getEntries).toVector
  def getEntries(feedUrl: String): Vector[RSSEntry] =
    getVectorEntries(getUrl(feedUrl)).map(entry => new RSSEntry(entry.getTitle, entry.getUri, entry.getUpdatedDate,
      asScala(entry.getLinks).toVector.head.getHref,
      asScala(entry.getContents).toVector.head.getValue,
      asScala(entry.getCategories).toVector.head.getName
    ))
}


