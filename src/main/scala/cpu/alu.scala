package cpu

import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.experimental.BundleLiterals._

object ALUOps {
  val nop :: add :: sub :: and :: xor :: or :: load :: shr :: Nil = Enum(8)
}

class ALU(width: Int) extends Module {
  val io = IO(new Bundle {
    val op = Input(UInt(3.W))
    val x = Input(SInt(width.W))
    val y = Input(SInt(width.W))
    val res = Output(SInt(width.W))
  })

  val r = WireDefault(0.S(width.W))
  val x = io.x
  val y = io.y
  val op = io.op

  switch(io.op) {
    is(ALUOps.add) {
      r := x + y
    }
  }

  io.res := r
}