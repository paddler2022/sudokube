import core.solver.MomentSolverAll
import frontend.{AND, MOMENT, NAIVE, UserCube}
import org.scalatest.{FlatSpec, Matchers}

class UserCubeSpec extends FlatSpec with Matchers{

  "UserCube" should "return right bits for cosmetic dimensions" in {
    val userCube = UserCube.createFromJson("recipes.json", "rating")
    assert(List(3) == userCube.accCorrespondingBits("Type", 1, 0, Nil))
    assert(List(3, 9) == userCube.accCorrespondingBits("Type", userCube.sch.n_bits, 0, Nil))
    assert(List() == userCube.accCorrespondingBits("not a field", userCube.sch.n_bits, 0, Nil))
  }

  "UserCube" should "return good matrix(not sliced)" in {
    val userCube = UserCube.createFromJson("recipes.json", "rating")
    val matrix = userCube.queryMatrix(List(("Region", 2), ("spicy", 1)),List(("Vegetarian", 1)), AND, MOMENT)
    assert("15.0" == matrix(3, 1))
    assert("12.0" == matrix(4, 1))
    assert("5.0" == matrix(6, 2))
  }

  "UserCube" should "sort result matrix by order of parameters" in {
    val userCube = UserCube.createFromJson("recipes.json", "rating")
    var matrix = userCube.queryMatrix(List(("spicy", 1), ("Region", 2)),List(("Vegetarian", 1)), AND, MOMENT)
    assert("15.0" == matrix(5, 1))
    assert("12.0" == matrix(7, 1))
    assert("5.0" == matrix(4, 2))
    matrix = userCube.queryMatrix(List(("Vegetarian", 1)),List(("spicy", 1), ("Region", 2)), AND, MOMENT)
    assert("15.0" == matrix(1, 5))
    assert("12.0" == matrix(1, 7))
    assert("5.0" == matrix(2, 4))
  }

  "UserCube" should "return same result in naive or moment method" in {
    val userCube = UserCube.createFromJson("recipes.json", "rating")
    val matrix1 = userCube.queryMatrix(List(("spicy", 1), ("Region", 2)),List(("Vegetarian", 1)), AND, MOMENT)
    val matrix2 = userCube.queryMatrix(List(("spicy", 1), ("Region", 2)),List(("Vegetarian", 1)), AND, NAIVE)
    assert(matrix1.equals(matrix2))
  }

  "UserCube" should "be able to dice some rows" in {
    val userCube = UserCube.createFromJson("recipes.json", "rating")
    var matrix = userCube.querySliceMatrix(List(("Region", 3, List("India")), ("spicy", 1, List()),
      ("Type", 1, List())),List(("Vegetarian", 1, List("1", "NULL"))), AND, MOMENT)
    assert(matrix.rows == 5)
    assert(matrix.cols == 2)
    matrix = userCube.querySliceMatrix(List(("Region", 3, List("India")), ("spicy", 1, List()),
      ("Type", 1, List())),List(("Vegetarian", 1, List("NoneValue"))), AND, MOMENT)
    assert(matrix.rows == 1 && matrix.cols == 1)
  }

  "UserCube" should "be able to load and save cubes" in {
    val userCube = UserCube.createFromJson("recipes.json", "rating")
    userCube.save("test")
    val loaded = UserCube.load("test")
    assert(loaded.cube.naive_eval(List(0)).sameElements(userCube.cube.naive_eval(List(0))))
    assert(loaded.sch.n_bits == userCube.sch.n_bits)
  }

}
