package streams

import streams._


object streamwksht {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(131); 


val testvec = Vector(Vector('a','b'),Vector('-','d'),Vector('e','f'))



class SPTerrain extends StringParserTerrain {
    val level = """ST
                  |oo
                  |oo""".stripMargin
};System.out.println("""testvec  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(testvec ));$skip(167); 

val spterrain = new SPTerrain();System.out.println("""spterrain  : streams.streamwksht.SPTerrain = """ + $show(spterrain ));$skip(33); val res$0 = 

spterrain.findChar('g',testvec);System.out.println("""res0: streams.streamwksht.spterrain.Pos = """ + $show(res$0));$skip(43); 
val f = spterrain.terrainFunction(testvec);System.out.println("""f  : streams.streamwksht.spterrain.Pos => Boolean = """ + $show(f ));$skip(26); val res$1 = 
f(new spterrain.Pos(1,1));System.out.println("""res1: Boolean = """ + $show(res$1));$skip(78); 

val myblock = spterrain.Block(new spterrain.Pos(0,0),new spterrain.Pos(0,1));System.out.println("""myblock  : streams.streamwksht.spterrain.Block = """ + $show(myblock ));$skip(20); val res$2 = 

myblock.isStanding;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(16); val res$3 = 
myblock.isLegal;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(43); val res$4 = 
                        
myblock.neighbors;System.out.println("""res4: List[(streams.streamwksht.spterrain.Block, streams.streamwksht.spterrain.Move)] = """ + $show(res$4));$skip(23); val res$5 = 
myblock.legalNeighbors



class SPSolver extends Solver with StringParserTerrain {
    val level = """So
                  |oo
                  |oT""".stripMargin
};System.out.println("""res5: List[(streams.streamwksht.spterrain.Block, streams.streamwksht.spterrain.Move)] = """ + $show(res$5));$skip(178); 





val spsolver = new SPSolver();System.out.println("""spsolver  : streams.streamwksht.SPSolver = """ + $show(spsolver ));$skip(53); 

val startS = Stream( (spsolver.startBlock,List()) );System.out.println("""startS  : scala.collection.immutable.Stream[(streams.streamwksht.spsolver.Block, List[Nothing])] = """ + $show(startS ));$skip(47); val res$6 = 
spsolver.from(startS,Set(spsolver.startBlock));System.out.println("""res6: Stream[(streams.streamwksht.spsolver.Block, List[streams.streamwksht.spsolver.Move])] = """ + $show(res$6));$skip(66); val res$7 = 
                                         


spsolver.pathsToGoal;System.out.println("""res7: Stream[(streams.streamwksht.spsolver.Block, List[streams.streamwksht.spsolver.Move])] = """ + $show(res$7));$skip(18); val res$8 = 
spsolver.solution;System.out.println("""res8: List[streams.streamwksht.spsolver.Move] = """ + $show(res$8))}
         
                           
              
            
                 
                        

               

}
