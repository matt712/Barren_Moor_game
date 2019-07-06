import scala.math.sqrt
object game {
  def main(args: Array[String]) {
    var world = generateWorld()
    println("You wake up in a barren moor, the mist surrounds you")
    println("In your hand you find a strange compass, that displays a number in its center")
    compassGame(world)
  }
  def generateWorld(): Array[Int] ={
    val randomer = new scala.util.Random()
    val x = randomer.nextInt(5)
    val y = randomer.nextInt(5)
    return Array(x, y)
  }
  def compassGame(world:Array[Int]): Unit ={
    var currentLocation = Array(0, 0)
    val scanner = new java.util.Scanner(System.in)
    var distance = (world(0)-currentLocation(0))^2 + (world(1) - currentLocation(1))^2
    while(distance != 0){
      println("The compass reads: " + sqrt(distance))
      println("Where would you like to go? [n, e, s, w]")
      val direction = scanner.nextLine()
      if(direction == "n"){
        currentLocation(1) += 1
      }
      else if(direction == "e"){
        currentLocation(0) += 1
      }
      else if(direction == "s"){
        currentLocation(1) -= 1
      }
      else if(direction == "w"){
        currentLocation(0) -=1
      }
      else{
        println("I do not understand the command")
      }
      distance = (world(0)-currentLocation(0))^2 + (world(1) - currentLocation(1))^2
    }
    println("You find an ornate box, then you wake up from the strange dream")
    scanner.close()
  }
}
