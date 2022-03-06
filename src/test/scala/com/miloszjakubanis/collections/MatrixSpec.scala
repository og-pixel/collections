package com.miloszjakubanis.collections

import utest.{TestSuite, Tests, test}

object MatrixSpec extends TestSuite {
  override def tests: Tests = Tests {
    test("One") - {

      val a = Matrix(Array(
        Array(1,1,1),
        Array(2,5,2),
        Array(3,6,3),
      )).get

      val b = a.appendRow(4,4,4)
      val c = a.appendColum(4,4,4)

      println(a)
      println(b.get)
      println(c.get)
      println(a.get(1, 2))


      println(a.appendColum(1, 1))
      println(a.appendColum(1, 1, 1, 1))

      println(a.appendRow(1, 1, 1, 1))
      println(a.appendRow(1, 1))

    }
  }
}
