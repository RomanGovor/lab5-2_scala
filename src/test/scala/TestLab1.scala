import org.scalatest.funsuite.AnyFunSuite

class TestLab1 extends AnyFunSuite {
  test("Max iteration of sequence") {
    val array = Array(3,5,6,6,6,6,3,4,3,3,2,5,4,4,5,6,5,6,5,5,5,5,5,5,5,5,9,9,9,9,9,8,5,8,8,8,8,8,8,8,4,5,67,6,7)
    assert((Lab.getMaxTailCall(array)).equals(Lab.getMaxRecursion(array)))
  }

}
