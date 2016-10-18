/**
  * Created by bbobb on 10/18/16.
  */

import scala.collection.mutable.ListBuffer

object FirstNonRepeatedChar {

  val string = "abcdabce"

  def methodOne {
    val stringChars = string.toList
    var uniqueChars = new ListBuffer[Char]
    stringChars.map(i => {
      val count = stringChars.count(_ == i)
      if (count.equals(1)) uniqueChars += i
    })
    println(s"methodOneOutput = ${uniqueChars.head}")
  }

  def methodTwo {
    val stringChars = string.toList
    stringChars.map(i => {
      if (stringChars.count(_ == i).equals(1)) {
        println(s"methodTwoOutput = ${i}")
        return -1
      }
    })

  }

  def methodThree {
    val output: Char = string.toList.groupBy(identity).filter(_._2.size == 1).last._1
    println(s"methodThreeOutput = $output")
  }

  def main(args: Array[String]): Unit = {
    methodOne // basic way
    methodTwo // efficient as it finds the first char and stops
    methodThree // one line output
  }

}
