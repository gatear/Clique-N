package actors

import akka.actor.{Actor, ActorRef, Props}
import models.{Vertex}

import scala.collection.mutable.ListBuffer


class VertexActor extends Actor {

  val log = akka.event.Logging(context.system, this)

  var vertexState: ListBuffer[models.Vertex] = new ListBuffer()

  override def receive: Receive = {

    case Vertex(info, adjacentVertices) => {
      log.info("This is the vertex " + info._1 + " with the reference " + adjacentVertices.filter(_._1 != info._1).map(_._1))
      vertexState += Vertex(info, adjacentVertices)

    }

    case _ => log.info(vertexState.last.Id.toString() + "  with " + vertexState.last.incidentVertices.toString())
  }

}