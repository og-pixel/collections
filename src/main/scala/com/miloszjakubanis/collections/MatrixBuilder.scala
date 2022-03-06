package com.miloszjakubanis.collections

object MatrixBuilder {

  def apply(elems: Int*): MatrixBuilder =
    new MatrixBuilder(Vector(elems.toVector))
}

class MatrixBuilder(val array: Vector[Vector[Int]]) {

  def apply(elems: Int*): MatrixBuilder =
    new MatrixBuilder(array.appended(elems.toVector))

  def apply(): Option[Matrix[Int]] =
    Matrix(array)
}