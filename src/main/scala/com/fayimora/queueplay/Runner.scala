package com.fayimora.queueplay
import com.typesafe.scalalogging.StrictLogging

object Runner extends StrictLogging {
    def main(args: Array[String]) = {
        // logger.debug("We are a go!")
        logger.trace("Trace log message")
        logger.debug("Debug log message")
        logger.info("Info log message")
        logger.warn("Warning log message")
        logger.error("Error log message")
    }
}