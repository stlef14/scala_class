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
                                                  //| in$1$SPTerrain$1@4bbc7636

spterrain.findChar('g',testvec)                   //> res0: streams.streamwksht.spterrain.Pos = Pos(-1,-1)
val f = spterrain.terrainFunction(testvec)        //> f  : streams.streamwksht.spterrain.Pos => Boolean = <function1>
f(new spterrain.Pos(1,1))                         //> res1: Boolean = true

val myblock = spterrain.Block(new spterrain.Pos(1,1),new spterrain.Pos(1,2))
                                                  //> myblock  : streams.streamwksht.spterrain.Block = Block(Pos(1,1),Pos(1,2))

myblock.isStanding                                //> res2: Boolean = false
myblock.isLegal                                   //> res3: Boolean = false
                        

}