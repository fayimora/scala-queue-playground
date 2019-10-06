package com.fayimora.queueplay
import akka.actor.Actor
import grizzled.slf4j.Logging
import com.fayimora.queueplay.AdderActor.Add
import awscala.sqs.Message
import scala.concurrent.Future
import play.api.libs.json.Json
import scala.util.Try

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

class AdderActor extends Actor with Logging with QueueHelper {
    def receive: Actor.Receive = {
        case Add =>
            info("Ready to add some numbers")
            sqs.withQueue(queue) { q =>
                val msgs = q.receive()
                info(s"Received ${msgs.length} messages")
                
                val processedMsgs = Future.sequence(msgs.map(add))
                val successfulMsgs = processedMsgs.map(_.filter(_.isSuccess).map(_.get))

                successfulMsgs.map { ls =>
                    ls.map { msg =>
                        warn(s"Deleting ${msg.body}")
                        q.delete(message = msg)
                    }    
                }
            }
    }

    def add(msg: Message): Future[Try[Message]] = {
        info(s"Processing ${msg.body}")
        val nums = Json.parse(msg.body).as[Vars]
        Future {
            Try(nums.a.toInt + nums.b.toInt).map(_ => msg)
        }
    }
}

object AdderActor {
    case object Add
}
