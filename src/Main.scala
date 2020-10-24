import EasyRSS.getEntries

object Main extends App {
  getEntries("https://www.reddit.com/r/Damnthatsinteresting/.rss").map(entry => {
    println(entry)
  })
}
