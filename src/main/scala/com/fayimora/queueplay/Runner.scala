package com.fayimora.queueplay
import grizzled.slf4j.Logging

object Runner extends Logging {
    def main(args: Array[String]) = {
        val producer = new Producer()
        producer.run()
    }
}
