package cl.uchile.dcc.citric
package model.norm

class Norma1Test extends munit.FunSuite {
  private var norma: Norma1 = _
  private var normaI: Norma1 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma1
    normaI = new Norma1
  }

  test("Norma1 approve his boost"){
    val normaBoost1: Boolean = norma.checkBoost(1,10,0)
    assertEquals(normaBoost1,true)
    val normaBoost2: Boolean = normaI.checkBoost(1, 0, 1)
    assertEquals(normaBoost2, true)
  }

  test("Norma1 don't approve his boost") {
    val normaBoost1: Boolean = norma.checkBoost(1, 9, 0)
    assertEquals(normaBoost1, false)
    val normaBoost2: Boolean = normaI.checkBoost(1, 0, 0)
    assertEquals(normaBoost2, false)
  }

  test("Norma1 should be able to upgrade to Norma2"){
    val finalNorma: Norma = norma.upgrade()
    assert(finalNorma.isInstanceOf[Norma2])
  }

  test("Norma1 give his value as an int"){
    val value: Int = norma.toNumber()
    assertEquals(value,1)
  }
}
