package com.rtjvm.scala.oop.filesystem

import com.rtjvm.scala.oop.commands.Command
import com.rtjvm.scala.oop.files.Directory

/**
  * Created by Daniel on 28-Oct-17.
  */
object Filesystem extends App {

  val root = Directory.ROOT

  // [1, 2, 3, 4]
  /*
   0 (op) 1 => 1
   1 (op) 2 => 3
   3 (op) 3 => 6
   6 (op) 4 => your last value, 10

   List(1,2,3,4).foldLeft(0)((x, y) => x + y)
    */
  val initialState = State(root, root)
  initialState.show
  io.Source.stdin.getLines().foldLeft(initialState)((state, line) => {
    val newState = Command.from(line).apply(state)
    newState.show
    newState
  })
}
