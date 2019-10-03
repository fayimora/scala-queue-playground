package com.fayimora.queueplay
import grizzled.slf4j.Logging

object Runner extends Logging {
    def main(args: Array[String]) = {
        trace("Trace log message")
        debug("Debug log message")
        info("Info log message")
        warn("Warning log message")
        error("Error log message")
    }
}
