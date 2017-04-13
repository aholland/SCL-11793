package scl_11793
object GlobalModel {
 object Mode extends Enumeration {
  type Mode = Value
 }
 def addModeListener(callback: (StateTransition[Mode.Value]) => Unit) = {}
 def setMode(mode: Mode.Value): Unit = {}
 def setDirty(dirty: Boolean) = ()
}
