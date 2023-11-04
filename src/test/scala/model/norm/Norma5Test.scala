package cl.uchile.dcc.citric
package model.norm

class Norma5Test extends munit.FunSuite {
  private var norma: Norma5 = _
  private var normaV: Norma5 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma5
    normaV = new Norma5
  }

  test("Norma5 approve his boost"){
    val normaBoost1: Boolean = norma.checkBoost(1,200,0)
    assertEquals(normaBoost1,true)
    val normaBoost2: Boolean = normaV.checkBoost(2, 0, 14)
    assertEquals(normaBoost2, true)
  }

  test("Norma5 don't approve his boost") {
    val normaBoost1: Boolean = norma.checkBoost(1, 121, 0)
    assertEquals(normaBoost1, false)
    val normaBoost2: Boolean = normaV.checkBoost(2, 0, 13)
    assertEquals(normaBoost2, false)
  }

  test("Norma5 should be able to upgrade to Norma6"){
    val finalNorma: Norma = norma.upgrade()
    assert(finalNorma.isInstanceOf[Norma6])
  }

  test("Norma5 give his value as an int") {
    val value: Int = norma.toNumber()
    assertEquals(value, 5)
  }
}
