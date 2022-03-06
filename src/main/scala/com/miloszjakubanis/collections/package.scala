package com.miloszjakubanis

package object collections {
  type MatrixType[V] = Vector[Vector[V]]

  val a = new Matrix(1,1,1)(1,1,1)(1,1,1)(1,1,1)
}
