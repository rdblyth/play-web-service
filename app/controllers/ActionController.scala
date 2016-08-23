package controllers

import domain.ObjectTypes._
import domain.{ObjectType, ObjectTypes, Verb, Verbs}
import domain.Verbs._
import play.api.libs.json._
import play.api.mvc.{Action, Controller}

object ActionController extends Controller {

  implicit val verbFormat = new Format[Verbs.EnumVal] {
    def reads(json: JsValue) = JsSuccess(Verb.withName(json.as[String]).get)
    def writes(v: Verbs.EnumVal) = JsString(v.toString)
  }

  implicit val objectTypeFormat = new Format[ObjectTypes.EnumVal] {
    def reads(json: JsValue) = JsSuccess(ObjectType.withName(json.as[String]).get)
    def writes(o: ObjectTypes.EnumVal) = JsString(o.toString)
  }

  implicit val actionFormat = Json.format[domain.Action]

  def createAction(verb: String, objectType: String, objectUri: String) = Action {
    Ok(s"Creating action with verb $verb objectType $objectType uri = $objectUri")
  }

  def getAction(id: Long)  = Action {
    Ok(Json.toJson(domain.Action(Some(1), MARK_AS_FAVORITE, ARTICLE, "uri")))
  }
}
