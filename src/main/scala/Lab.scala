//5.Найти длину наибольшей последовательности одинаковых чисел идущих подряд


// По заданию работа с консолью должна не присутствовать,
// исходя из этого ввода нету, а данные берутся из main(а)


import scala.annotation.tailrec

object Lab {
  //хвостовая рекурсия
  def getMaxTailCall(array: Array[Int]):Int = {
    @tailrec
    def getMax(array: Array[Int], i:Int, res:Int, counter:Int): Int = {
      if (i == array.length) {                                 // Если конец массива
        if (counter > res) counter
        else res
      }
      else if (i != 0 && array(i - 1).equals(array(i))) {      // Если предыдущий элемент одинаков с текущим
        getMax(array, i + 1, res, counter + 1)                 // Если найдена большая одинаковая последовательность
      }
      else {
        if (counter > res) {
          getMax(array, i + 1, counter, 1)
        } else {
          getMax(array, i + 1, res, 1)
        }
      }
    }

    getMax(array, 0, 1, 1)
  }


  private def formatGetMaxTailCall(array: Array[Int]):String = {
    val str = "Max iteration of sequence: %d"
    str.format(getMaxTailCall(array))
  }


  //простая рекурсия
  def getMaxRecursion(array: Array[Int]): Int = {

    def getMax(array: Array[Int], i:Int, res:Int, counter:Int, rest:Int):Int = {
      if (i == array.length) {                               // Если конец массива
        if (counter > res) counter + 1 - res
        else 1
      }
      else if (i != 0 && array(i - 1).equals(array(i))) {    // Если предыдущий элемент одинаков с текущим
        if (counter + 1 - res > 0) {                         // Если найдена большая одинаковая последовательность
          getMax(array, i + 1, res, counter + 1, counter + 1 - res)
        } else {
          getMax(array, i + 1, res, counter + 1, 0)
        }
      }
      else {
        if (counter > res) {
          rest + getMax(array, i + 1, counter, 1, 0)
        } else {
          getMax(array, i + 1, res, 1, 0)
        }
      }
    }

    getMax(array, 0, 1, 1, 0)
  }


  private def formatGetMaxRecursion(array: Array[Int]):String = {
    val str = "Max iteration of sequence with recursion: %d"
    str.format(getMaxRecursion(array))
  }


  def main(args: Array[String]): Unit = {

    val array = Array(3,4,5,6,2,8,9,4,4,4,5,6,3,3,3,2,2,2,2,2,2,2,7,4,4,4,4,4,4,4,4,4,4)
    println(formatGetMaxTailCall(array))
    println(formatGetMaxRecursion(array))
  }

}
