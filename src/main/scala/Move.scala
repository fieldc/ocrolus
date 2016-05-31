import Board.{Empty, Occupied, Position, Square}
/**
  * Created by chris on 5/27/16.
  */

object Mover{

  def discoverNext(square: Occupied): List[Occupied] = {
    Moves.all.map((potentialMove)=>{
      Board.squareAt(square.position.move(potentialMove))
    }).collect({case s: Some[Occupied] => s.get})
  }
}

