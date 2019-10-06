package com.fayimora.queueplay
import play.api.libs.json.Json

case class Vars(a: String, b: String)

object Vars {
    implicit val format = Json.format[Vars]
}