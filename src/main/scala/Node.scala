import Board.{Occupied}

/**
  * Created by chris on 5/28/16.
  */

class Node(square:Occupied, depth:Int, vowelDepth:Int) {
  var children: List[Node] = List[Node]()
  val mySquare:Occupied = square
  val myDepth:Int = depth


  def findChildren(depthSought:Int):Unit = {
    if(depth>=depthSought) {
      return
    }

    this.children =  Mover.discoverNext(square).map(m =>{
      if(!m.isVowel || (vowelDepth+1)<=2){
        val n = new Node(m,depth+1, if (m.isVowel) vowelDepth+1 else 0 )
        n.findChildren(depthSought)
        Some(n)
      }
      else None
    } ).collect({case s: Some[Node] => s.get})
  }
}
