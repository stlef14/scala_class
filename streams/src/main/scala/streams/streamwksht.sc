package streams

import streams._


object streamwksht {


val testvec = Vector(Vector('a','b'),Vector('-','d'),Vector('e','f'))
                                                  //> testvec  : scala.collection.immutable.Vector[scala.collection.immutable.Vect
                                                  //| or[Char]] = Vector(Vector(a, b), Vector(-, d), Vector(e, f))



class SPTerrain extends StringParserTerrain {
    val level = """ST
                  |oo
                  |oo""".stripMargin
}

val spterrain = new SPTerrain()                   //> spterrain  : streams.streamwksht.SPTerrain = streams.streamwksht$$anonfun$ma
                                                  //| in$1$SPTerrain$1@44655c8c

spterrain.findChar('g',testvec)                   //> res0: streams.streamwksht.spterrain.Pos = Pos(-1,-1)
val f = spterrain.terrainFunction(testvec)        //> f  : streams.streamwksht.spterrain.Pos => Boolean = <function1>
f(new spterrain.Pos(1,1))                         //> res1: Boolean = true

val myblock = spterrain.Block(new spterrain.Pos(0,0),new spterrain.Pos(0,1))
                                                  //> myblock  : streams.streamwksht.spterrain.Block = Block(Pos(0,0),Pos(0,1))

myblock.isStanding                                //> res2: Boolean = false
myblock.isLegal                                   //> res3: Boolean = true
                        
myblock.neighbors                                 //> res4: List[(streams.streamwksht.spterrain.Block, streams.streamwksht.spterra
                                                  //| in.Move)] = List((Block(Pos(0,-1),Pos(0,-1)),Left), (Block(Pos(0,2),Pos(0,2)
                                                  //| ),Right), (Block(Pos(-1,0),Pos(-1,1)),Up), (Block(Pos(1,0),Pos(1,1)),Down))
                                                  //| 
myblock.legalNeighbors                            //> res5: List[(streams.streamwksht.spterrain.Block, streams.streamwksht.spterra
                                                  //| in.Move)] = List((Block(Pos(1,0),Pos(1,1)),Down))



class SPSolver extends Solver with StringParserTerrain {
    val level = """So
                  |oo
                  |oT""".stripMargin
}



val spsolver = new SPSolver()                     //> spsolver  : streams.streamwksht.SPSolver = streams.streamwksht$$anonfun$main
                                                  //| $1$SPSolver$1@10c03c6

val startS = Stream( (spsolver.startBlock,List()) )
                                                  //> startS  : scala.collection.immutable.Stream[(streams.streamwksht.spsolver.Bl
                                                  //| ock, List[Nothing])] = Stream((Block(Pos(0,0),Pos(0,0)),List()), ?)
spsolver.from(startS,Set(spsolver.startBlock))    //> res6: Stream[(streams.streamwksht.spsolver.Block, List[streams.streamwksht.s
                                                  //| psolver.Move])] = Stream((Block(Pos(0,0),Pos(0,0)),List()), ?)
                                         

spsolver.pathsFromStart                           //> res7: Stream[(streams.streamwksht.spsolver.Block, List[streams.streamwksht.s
                                                  //| psolver.Move])] = Stream((Block(Pos(0,0),Pos(0,0)),List()), ?)
spsolver.solution                                 //> java.util.NoSuchElementException: head of empty stream
                                                  //| 	at scala.collection.immutable.Stream$Empty$.head(Stream.scala:1028)
                                                  //| 	at scala.collection.immutable.Stream$Empty$.head(Stream.scala:1026)
                                                  //| 	at streams.Solver$class.solution(Solver.scala:128)
                                                  //| 	at streams.streamwksht$$anonfun$main$1$SPSolver$1.solution$lzycompute(st
                                                  //| reams.streamwksht.scala:35)
                                                  //| 	at streams.streamwksht$$anonfun$main$1$SPSolver$1.solution(streams.strea
                                                  //| mwksht.scala:35)
                                                  //| 	at streams.streamwksht$$anonfun$main$1.apply$mcV$sp(streams.streamwksht.
                                                  //| scala:50)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at streams.streamwksht$.main(streams.streamwksht.scala:6)
                                                  //| 	at streams.strea
                                                  //| Output exceeds cutoff limit.
               

}