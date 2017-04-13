package scl_11793
import org.scalajs.dom._
import org.scalajs.dom.html.{Option => HtmlOption, Map => _, _}
import org.scalajs.dom.html.Element
import GlobalModel.Mode._
import scl_11793.Couple.EditorMaker
abstract class CrmSection() {
 val model = GlobalModel
 private val couples: scala.collection.mutable.ListBuffer[FieldCouple[_]] = new scala.collection.mutable.ListBuffer[FieldCouple[_]]
 private val dirtListener: () => Unit = () => model.setDirty(couples.exists(_.dirty))
 model.addModeListener(st => {
  dirtListener()
   couples.foreach(_.abandonEdits())
 })
 abstract class CrmCouple[F, +EditorType <: Editor[CrmContractorBar, F]](val fieldLabel: String
                                                                , f: ((CrmContractorBar, F) => Span)
                                                                , editorCurried: EditorMaker[EditorType]
                                                                , inlineEdit: Boolean = false
                                                                , backgroundColor: String = "") extends
  Couple[CrmContractorBar, F, EditorType](dirtListener) {
 }
 type EditorType[F] = FieldEditor[CrmContractorBar, CrmContractorId, F]
 abstract class FieldCouple[F](
                      label: String
                      , f: (F => Span)
                      , editorCurried: (Element, Boolean, Option[Set[Mode]]) => EditorType[F]
                      , inlineEdit: Boolean = false)
  extends CrmCouple[F, EditorType[F]](label, (dv, fv) => f(fv), editorCurried, inlineEdit) {
  couples += this
 }
}