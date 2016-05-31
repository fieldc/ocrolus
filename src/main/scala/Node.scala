import Board.Occupied

/**
  * Created by chris on 5/28/16.
  */

/** Defines a node in the move tree
  *
  * Applies a depth first process to discover potential paths.
  *
  * @param square square that this node represents
  * @param depth current path length / tree depth
  * @param vowelDepth current number of vowels in a row
  */
class Node(square:Occupied, depth:Int, vowelDepth:Int) {
  var children: List[Node] = List[Node]()
  val mySquare:Occupied = square
  val myDepth:Int = depth


  /** Find all the children (next positions) from the current square
    *
    * Applies the vowel rule to the list of valid next positions returned from mover.
    *
    * @param depthSought The desired number of moves
    */
  def findChildren(depthSought:Int):Unit = {
    if(depth>=depthSought) {
      return
    }

    /** first we find all the potential valid moves using discoverNext */
    this.children =  Mover.discoverNext(square).map(m =>{
      /** then we apply our vowel rule */
      if(!m.isVowel || (vowelDepth+1)<=2){
        /** this is a valid next step, continue with this path */
        val n = new Node(m,depth+1, if (m.isVowel) vowelDepth+1 else 0 )
        n.findChildren(depthSought)
        Some(n)
      }
      else None
    } ).collect({case s: Some[Node] => s.get})
  }
}
