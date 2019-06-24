package example

import com.typesafe.config.ConfigFactory

object Hello extends App {
  val conf = ConfigFactory.load
  println("conf.getString(\"simple\") is " + conf.getString("simple"))
  println("conf.getString(\"definedInAnother\") is " + conf.getString("definedInAnother"))
  println("conf.getString(\"mergedFromAnother\") is " + conf.getString("mergedFromAnother"))
  println("conf.getString(\"application.mergedFromAnother\") is " + conf.getString("application.mergedFromAnother"))
  println("conf.getString(\"application.additionalFromAnother\") is " + conf.getString("application.additionalFromAnother"))
  println("conf.getString(\"application.additionalFromApplication\") is " + conf.getString("application.additionalFromApplication"))
}
