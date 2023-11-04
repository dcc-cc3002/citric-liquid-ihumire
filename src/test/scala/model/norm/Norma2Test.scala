package cl.uchile.dcc.citric
package model.norm

class Norma2Test extends munit.FunSuite {
  private var norma: Norma2 = _
  private var normaII: Norma2 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma2
    normaII = new Norma2
  }

  test("Norma2 approve his boost"){
    val normaBoost1: Boolean = norma.checkBoost(1,30,0)
    assertEquals(normaBoost1,true)
    val normaBoost2: Boolean = normaII.checkBoost(2, 0, 3)
    assertEquals(normaBoost2, true)
  }

  test("Norma2 don't approve his boost") {
    val normaBoost1: Boolean = norma.checkBoost(1, 11, 0)
    assertEquals(normaBoost1, false)
    val normaBoost2: Boolean = normaII.checkBoost(2, 0, 2)
    assertEquals(normaBoost2, false)
  }

  test("Norma2 should be able to upgrade to Norma3"){
    val finalNorma: Norma = norma.upgrade()
    assert(finalNorma.isInstanceOf[Norma3])
  }

  test("Norma2 give his value as an int") {
    val value: Int = norma.toNumber()
    assertEquals(value, 2)
  }
}
