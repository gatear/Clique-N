
package main

import actors.{Vertex, VertexActor}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.collection.mutable.ListBuffer


object Main extends App{

  val system = ActorSystem("testSystem")
  val list:ListBuffer [(String, ActorRef)] = new ListBuffer[(String, ActorRef)]



  for ( node <- 1 to 10) {

    println( "Creating Vertex Actor number "+ node)

    list += ( (node.toString, system.actorOf( Props[VertexActor], "Vertex"+node)) )

  }

  for ( tuple <- list){
    tuple._2 ! Vertex( tuple , list.toList)
    println("Sending message to "+ tuple._2)
  }
}
