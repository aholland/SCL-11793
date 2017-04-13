package scl_11793
import org.scalajs.dom._
import org.scalajs.dom.html.{Option => HtmlOption, Map => _, _}
import org.scalajs.dom.html.Element
import GlobalModel.Mode._
import scl_11793.Couple.EditorMaker

abstract class Couple[DataType, FieldType, +EditorType <: Editor[DataType, FieldType]](dirtListener: () => Unit) {
 def dirty: Boolean = true
 def abandonEdits(): Unit = {}
}

object Couple {
 type EditorMaker[EditorType] = (Element, Boolean, Option[Set[Mode]]) => EditorType
}