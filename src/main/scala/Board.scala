import Moves.Move

import scala.math._

/**
  * Created by chris on 5/28/16.
  */
object Board {

  trait Square {
    def position:Position
  }
  case class Occupied(position:Position,key:String,isVowel:Boolean=false) extends Square
  case class Empty(position:Position) extends Square
  case class Position(row:Int,col:Int)

  val layout = List[Square](
    Occupied(Position(1,1),"A",isVowel=true),Occupied(Position(1,2),"B"),Occupied(Position(1,3),"C"),Occupied(Position(1,4),"D"),Occupied(Position(1,5),"E",isVowel=true),
    Occupied(Position(2,1),"F"),Occupied(Position(2,2),"G"),Occupied(Position(2,3),"H"),Occupied(Position(2,4),"I",isVowel=true),Occupied(Position(2,5),"J"),
    Occupied(Position(3,1),"K"),Occupied(Position(3,2),"L"),Occupied(Position(3,3),"M"),Occupied(Position(3,4),"N"),Occupied(Position(3,5),"O",isVowel=true),
    Empty(Position(4,1)),Occupied(Position(4,2),"1"),Occupied(Position(4,3),"2"),Occupied(Position(4,4),"3"),Empty(Position(4,5))
  )

  val columns:Int = 5
  val rows:Int = 4

  def squareAt(p:Position):Option[Occupied] = {
    if(p.col<0 || p.col>=columns)
      return None

    if(p.row<0 || p.row>=rows)
      return None

    layout(p.asIndex(columns)) match {
      case m:Empty => None
      case m:Occupied => Some(m)
    }
  }

  implicit class PositionHelpers(p:Position) {
    def asIndex(width: Int): Int = {
      (p.row * width) + p.col
    }

    def move(move:Move) = {
      Position(p.row+move.moveRow,p.col+move.moveCol)
    }

  }

}

