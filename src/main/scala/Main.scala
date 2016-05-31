/**
  * Created by chris on 5/26/16.
  */
import Board._

object Main {

  case class Config(pathLength:Int=10,startKey:String)

  def main(args: Array[String]): Unit = {
    if(args.length < 2){
      printf("run with startkey depth")
      sys.exit(1)
    }

    val startIndex  = layout.indexWhere( (sq)=> sq.isInstanceOf[Occupied] && sq.asInstanceOf[Occupied].key==args.apply(0))
    val depth = args.apply(1).toInt
    layout(startIndex) match {
      case m:Occupied=>{

        val root=new Node(m,1,if(m.isVowel) 1 else 0 )
        println("Building move tree")
        root.findChildren(depth)

        println("Counting paths")
        val count = countPaths(root,depth)
        println(s"Found ${count} paths of depth ${depth}")
      }
      case m:Empty=> println(s"Invalid start index calculated startIndex=$startIndex")
    }

  }

  def countPaths(node:Node, toDepth:Int):Int = {
    if(node.myDepth==toDepth) {
      return 1
    }

    if (node.children.length==0)
      return 0

    node.children.map(n=>{
      countPaths(n,toDepth)
    }).foldLeft(0)((wasReqDepth,sum)=>wasReqDepth+sum)
  }
}
