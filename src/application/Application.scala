
package application

import actors.VertexActor
import akka.actor.{ActorRef, ActorSystem, Props}
import models.Vertex

import scala.collection.mutable.ListBuffer


object Application extends App {

  val system = ActorSystem("testSystem")
  val list: ListBuffer[(String, ActorRef)] = new ListBuffer[(String, ActorRef)]


  for (node <- 1 to 10) {

    println("Creating Vertex Actor number " + node)

    list += ((node.toString, system.actorOf(Props[VertexActor], "Vertex" + node)))

  }

  for (tuple <- list) {
    tuple._2 ! Vertex(tuple, list.toList)
    println("Sending message to " + tuple._2)
  }
  for (tuple <- list) {
    tuple._2 ! "print stateful info"
    println("Sending PRINT message to " + tuple._2)
  }

}
