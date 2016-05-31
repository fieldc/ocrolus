/**
  * Created by chris on 5/28/16.
  *
  * Object contains all the possible moves from a particular position
  */
object Moves {

  trait Move {
    def moveCol: Int
    def moveRow: Int
  }

  case class LeftUp   (moveCol: Int = -2, moveRow: Int = 1) extends Move
  case class LeftDown (moveCol: Int = -2, moveRow: Int = -1) extends Move

  case class DownLeft (moveCol: Int = -1, moveRow: Int = 2) extends Move
  case class DownRight(moveCol: Int = 1,  moveRow: Int = 2) extends Move

  case class RightUp  (moveCol: Int = 2, moveRow: Int = -1) extends Move
  case class RightDown(moveCol: Int = 2,  moveRow: Int = 1) extends Move

  case class UpRight  (moveCol: Int = 1,  moveRow: Int = -2) extends Move
  case class UpLeft   (moveCol: Int = -1,  moveRow: Int = -2) extends Move

  val all = List[Move](LeftUp(),LeftDown(),DownLeft(),DownRight(),RightUp(),RightDown(),UpRight(),UpLeft())

}
