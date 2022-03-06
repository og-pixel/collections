package com.miloszjakubanis.collections

import scala.reflect.ClassTag

object Matrix {

  def apply[V: ClassTag](arr: MatrixType[V]): Option[Matrix[V]] = {
    if (checkMatrix(arr)) Some(new Matrix(arr))
    else None
  }

  def apply[V: ClassTag](arr: Array[Array[V]]): Option[Matrix[V]] =
    Matrix.apply(arr.map(_.toVector).toVector)

  def apply[V: ClassTag](arr: Seq[Seq[V]]): Option[Matrix[V]] =
    Matrix.apply(arr.map(_.toVector).toVector)


  protected def checkMatrix[V: ClassTag](arr: MatrixType[V]): Boolean = {
    //noinspection FoldTrueAnd
    arr
      .map(_.length == arr(0).length)
      .fold(true)(_ && _)
  }

}

protected class Matrix[V: ClassTag](private[this] val arr: MatrixType[V]) {

  def get(x: Int, y: Int): Option[V] = {
    Option(arr(y)(x))
  }

  def appendRow(elem: V*): Option[Matrix[V]] = {
    if (elem.length == arr(0).length) Matrix(arr.appended(elem))
    else None
  }

  def prependRow(elem: V*): Option[Matrix[V]] = {
    if (elem.length == arr(0).length) Matrix(arr.prepended(elem))
    else None
  }

  def appendColum(elem: V*): Option[Matrix[V]] = {
    if (elem.length == arr.length)
      Matrix(
        arr
          .zipWithIndex
          .map(e => e._1.appended(elem(e._2))))
    else None
  }

  def prependColumn(elem: V*): Option[Matrix[V]] =
    if (elem.length == arr.length)
      Matrix(
        arr
          .zipWithIndex
          .map(e => e._1.prepended(elem(e._2))))
    else None


  def getRow(y: Int): Option[Vector[V]] = {
    if(y >= 0 && y < arr(0).length) Some(arr(y))
    else None
  }

  def getColumn(x: Int): Option[Vector[V]] = {
    if(x >= 0 && x < arr.length) Some(arr(x))
    Some(arr.map(e => e(x)))
  }

  override def toString: String = {
    "Matrix:\n" +
      arr
        .map(e => e.mkString("  (", ", ", ")\n"))
        .mkString("", "", "")
  }

  protected def checkWidth[V: ClassTag](arr: MatrixType[V], x: Int): Boolean = {
    x >= 0 && x <= arr(0).length
  }

  protected def checkHeight[V: ClassTag](arr: MatrixType[V], y: Int): Boolean = {
    y >= 0 && y <= arr.length
  }
}
