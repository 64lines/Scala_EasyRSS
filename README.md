# Easy RSS

A little Scala library that allows you to read RSS entries in a very straightforward way.

```scala
import EasyRSS.getEntries

object Main extends App {
  getEntries("https://www.reddit.com/r/Damnthatsinteresting/.rss").map(entry => {
    println(entry)
  })
}
```