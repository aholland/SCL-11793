package scl_11793

import slick.lifted.MappedTo
abstract class DbId[T](innerId: T) extends MappedTo[T] {
 def isNew: Boolean
 override def value: T = innerId
}
class IntId(innerId: Int) extends DbId[Int](innerId) { override def isNew: Boolean = value < 0}
class LongId(innerId: Long) extends DbId[Long](innerId) { override def isNew: Boolean = value < 0}
class ShortId(innerId: Short) extends DbId[Short](innerId) { override def isNew: Boolean = value < 0}
