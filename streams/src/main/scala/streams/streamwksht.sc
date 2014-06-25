package streams

import streams._


object streamwksht {


val testvec = Vector(Vector('a','b'),Vector('-','d'),Vector('e','f'))



class SPTerrain extends StringParserTerrain {
    val level = """ST
                  |oo
                  |oo""".stripMargin
}

val spterrain = new SPTerrain()

spterrain.findChar('g',testvec)
val f = spterrain.terrainFunction(testvec)
f(new spterrain.Pos(1,1))

val myblock = spterrain.Block(new spterrain.Pos(0,0),new spterrain.Pos(0,1))

myblock.isStanding
myblock.isLegal
                        
myblock.neighbors
myblock.legalNeighbors

class SPSolver extends SPTerrain, Solver {}

val spsolver = new SPSolver()

 spsolver.from(Stream((spterrain.startBlock,List())),List(spterrain.startBlock))
}