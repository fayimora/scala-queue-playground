package com.fayimora.queueplay
import grizzled.slf4j.Logging
import akka.actor.ActorSystem
import akka.actor.Props

object Runner extends Logging {
    def main(args: Array[String]): Unit = {
        val system = ActorSystem("ScalaQueueSystem")

        // Schedule this in a job with some randomness
        val producer = new Producer()
        producer.run()

        val adder = system.actorOf(Props[AdderActor])
        val consumer = new Consumer(system, adder)
        consumer.setup()
    }
}
