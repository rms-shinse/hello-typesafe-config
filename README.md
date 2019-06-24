`application.conf`
```hocon
include "another"

simple = "simple"
mergedFromAnother = "application.conf"
application {
  mergedFromAnother = "application.conf"
  additionalFromApplication = "I'm additional from application.conf"
}
```

`another.conf`
```hocon
definedInAnother = "definedInAnother"
mergedFromAnother = "another.conf"
application {
  mergedFromAnother = "another.conf"
  additionalFromAnother = "I'm additional from another.conf"
}
```

```scala
object Hello extends App {
  val conf = ConfigFactory.load
  println("conf.getString(\"simple\") is " + conf.getString("simple"))
  println("conf.getString(\"definedInAnother\") is " + conf.getString("definedInAnother"))
  println("conf.getString(\"mergedFromAnother\") is " + conf.getString("mergedFromAnother"))
  println("conf.getString(\"application.mergedFromAnother\") is " + conf.getString("application.mergedFromAnother"))
  println("conf.getString(\"application.additionalFromAnother\") is " + conf.getString("application.additionalFromAnother"))
  println("conf.getString(\"application.additionalFromApplication\") is " + conf.getString("application.additionalFromApplication"))
}
// => conf.getString("simple") is simple
// => conf.getString("definedInAnother") is definedInAnother
// => conf.getString("mergedFromAnother") is application.conf
// => conf.getString("application.mergedFromAnother") is application.conf
// => conf.getString("application.additionalFromAnother") is I'm additional from another.conf
// => conf.getString("application.additionalFromApplication") is I'm additional from application.conf
```