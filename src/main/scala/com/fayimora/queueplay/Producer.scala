package com.fayimora.queueplay
import grizzled.slf4j.Logging
import awscala.sqs.{SQS, Queue}
import awscala.Region0
import awscala.sqs.MessageBatchEntry
import java.{util => ju}
import play.api.libs.json.Json

class Producer extends QueueHelper with Logging {
    
    def run() = {
        info("Generating numbers for queue")
        val top = 1 to 10
        val bottom = top.reverse
        val msgs = top.zip(bottom).map { case (a, b) =>
            MessageBatchEntry(
                ju.UUID.randomUUID().toString(),
                Json.toJson(Vars(a.toString, b.toString)).toString()
            )
        }
        info(s"${msgs.length} numbers generated for the queue")
        
        info(s"Sending msgs to queue, $queueName")
        sqs.withQueue(queue) { q =>
            q.sendMessageBatch(msgs: _*)
        }
        info("Messages has been sent to the queue")
    }
}
