/**
  * Created by chris on 5/26/16.
  */
import Board._

/**
  * This program applies a basic brute force approach to solving the problem of counting the paths.
  */
object Main {

  def main(args: Array[String]): Unit = {
    if(args.length < 2){
      printf("run with startkey depth")
      sys.exit(1)
    }

    val startIndex  = layout.indexWhere( (sq)=> sq.isInstanceOf[Occupied] && sq.asInstanceOf[Occupied].key==args.apply(0))
    val depth = args.apply(1).toInt
    layout(startIndex) match {
      case m:Occupied=>{

        /** start our depth first search process with the root node */
        val root=new Node(m,0,if(m.isVowel) 1 else 0 )
        println("Building move tree")
        root.findChildren(depth)

        /** now that we have the full tree of moves discovered we can count out our paths */
        println("Counting paths")
        val count = countPaths(root,depth)
        println(s"Found $count paths of depth $depth")
      }
      case m:Empty=> println(s"Invalid start index calculated startIndex=$startIndex")
    }

  }

  def countPaths(node:Node, toDepth:Int):Int = {
    if(node.myDepth==toDepth) {
      return 1
    }

    if (node.children.isEmpty)
      return 0

    /** sum the results of the recursive calls */
    node.children.map(n=>{
      countPaths(n,toDepth)
    }).foldLeft(0)((wasReqDepth,sum)=>wasReqDepth+sum)
  }
}
