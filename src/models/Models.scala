package models

import akka.actor.ActorRef

case class VertexState(vertex: Vertex)

case class Comand(data: String)

case class Event(data: String)

case class Vertex(Id: (String, ActorRef), incidentVertices: List[(String, ActorRef)])()