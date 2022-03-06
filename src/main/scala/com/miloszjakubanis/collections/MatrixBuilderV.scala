package com.miloszjakubanis.collections

import scala.reflect.ClassTag

object MatrixBuilderV {

  def apply[V: ClassTag](elems: V*): MatrixBuilderV[V] = {
    new MatrixBuilderV(Vector(elems.toVector))
  }

}

class MatrixBuilderV[V: ClassTag](val array: Vector[Vector[V]]) {

  def apply(elems: V*): MatrixBuilderV[V] =
    new MatrixBuilderV(array.appended(elems.toVector))

  def apply(): Option[Matrix[V]] = Matrix(array)

}