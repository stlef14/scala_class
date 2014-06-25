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

class SPSolver extends SPTerrain, Solver {};System.out.println("""res5: List[(streams.streamwksht.spterrain.Block, streams.streamwksht.spterrain.Move)] = """ + $show(res$5));$skip(76); 

val spsolver = new SPSolver();System.out.println("""spsolver  : streams.streamwksht.SPSolver = """ + $show(spsolver ));$skip(82); val res$6 = 

 spsolver.from(Stream((spterrain.startBlock,List())),List(spterrain.startBlock));System.out.println("""res6: <error> = """ + $show(res$6))}
}
