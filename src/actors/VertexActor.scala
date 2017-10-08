package actors

import akka.actor.{Actor, ActorRef, Props}


case class Vertex ( Id :(String ,ActorRef) ,incidentVertices : List [ (String,ActorRef) ] )

class VertexActor extends Actor{

   val log=    akka.event.Logging(context.system, this)

  override def receive: Receive = {

    case Vertex ( info ,incidentVertices) =>  {
                                                log.info ("This is the vertex " + info._1 + " with the reference "+ incidentVertices.filter(_._1 != info._1).map(_._1) )

                                              }

    case _ => log.info(context.self +" received unknown message from " + context.sender() )

  }

}