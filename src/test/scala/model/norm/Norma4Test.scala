package cl.uchile.dcc.citric
package model.norm

class Norma4Test extends munit.FunSuite {
  private var norma: Norma4 = _
  private var normaIV: Norma4 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma4
    normaIV = new Norma4
  }

  test("Norma4 approve his boost"){
    val normaBoost1: Boolean = norma.checkBoost(1,120,0)
    assertEquals(normaBoost1,true)
    val normaBoost2: Boolean = normaIV.checkBoost(2, 0, 10)
    assertEquals(normaBoost2, true)
  }

  test("Norma4 don't approve his boost") {
    val normaBoost1: Boolean = norma.checkBoost(1, 71, 0)
    assertEquals(normaBoost1, false)
    val normaBoost2: Boolean = normaIV.checkBoost(2, 0, 9)
    assertEquals(normaBoost2, false)
  }

  test("Norma4 should be able to upgrade to Norma5"){
    val finalNorma: Norma = norma.upgrade()
    assert(finalNorma.isInstanceOf[Norma5])
  }

  test("Norma4 give his value as an int") {
    val value: Int = norma.toNumber()
    assertEquals(value, 4)
  }
}
