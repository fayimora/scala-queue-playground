package com.fayimora.queueplay
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension
import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.ActorRef

class Consumer(val system: ActorSystem, val adder: ActorRef) {
    def setup() = {
        QuartzSchedulerExtension(system).schedule("AdderActor", adder, AdderActor.Add)
    }
}