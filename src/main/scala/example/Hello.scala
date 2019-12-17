package example

import com.typesafe.config.{Config, ConfigFactory}

object Hello extends App {
  val conf = ConfigFactory.load
  printConf(conf, "simple")
  printConf(conf, "definedInAnother")
  printConf(conf, "mergedFromAnother")
  printConf(conf, "application.mergedFromAnother")
  printConf(conf, "application.additionalFromAnother")
  printConf(conf, "application.additionalFromApplication")

  def printConf(conf: Config, key: String): Unit = println(s"""conf.getString("$key") is ${conf.getString(key)}""")
}
