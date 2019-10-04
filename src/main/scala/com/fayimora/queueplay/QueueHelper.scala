package com.fayimora.queueplay
import awscala.sqs.SQS
import awscala.Region0
import awscala.sqs.Queue

trait QueueHelper {
    implicit val sqs: SQS = SQS.at(Region0.London)
    val queueName = "numbers"
    val queue: Queue = sqs.queue(queueName)
        .getOrElse(sqs.createQueueAndReturnQueueName((queueName)))
}
