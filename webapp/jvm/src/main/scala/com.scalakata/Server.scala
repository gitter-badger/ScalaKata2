package com.scalakata

import upickle._
import spray.routing.SimpleRoutingApp
import akka.actor.ActorSystem
import scala.concurrent.ExecutionContext.Implicits.global
import spray.http.{MediaTypes, HttpEntity}

object AutowireServer extends autowire.Server[String, upickle.Reader, upickle.Writer]{
  def read[Result: upickle.Reader](p: String) = upickle.read[Result](p)
  def write[Result: upickle.Writer](r: Result) = upickle.write(r)
}
object Server extends SimpleRoutingApp with EvalImpl {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    startServer("0.0.0.0", port = 8080) {
      get{
        pathSingleSlash {
          complete{
            HttpEntity(
              MediaTypes.`text/html`,
              Template.txt
            )
          }
        } ~
        getFromResourceDirectory("")
      } ~
      post {
        path("api" / Segments){ s ⇒
          extract(_.request.entity.asString) { e ⇒
            complete {
              AutowireServer.route[Api](Server)(
                autowire.Core.Request(s, upickle.read[Map[String, String]](e))
              )
            }
          }
        }
      }
    }
  }
}
