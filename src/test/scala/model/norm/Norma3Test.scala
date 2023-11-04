package cl.uchile.dcc.citric
package model.norm

class Norma3Test extends munit.FunSuite {
  private var norma: Norma3 = _
  private var normaIII: Norma3 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma3
    normaIII = new Norma3
  }

  test("Norma3 approve his boost"){
    val normaBoost1: Boolean = norma.checkBoost(1,70,0)
    assertEquals(normaBoost1,true)
    val normaBoost2: Boolean = normaIII.checkBoost(2, 0, 6)
    assertEquals(normaBoost2, true)
  }

  test("Norma3 don't approve his boost") {
    val normaBoost1: Boolean = norma.checkBoost(1, 31, 0)
    assertEquals(normaBoost1, false)
    val normaBoost2: Boolean = normaIII.checkBoost(2, 0, 5)
    assertEquals(normaBoost2, false)
  }

  test("Norma3 should be able to upgrade to Norma4"){
    val finalNorma: Norma = norma.upgrade()
    assert(finalNorma.isInstanceOf[Norma4])
  }

  test("Norma3 give his value as an int") {
    val value: Int = norma.toNumber()
    assertEquals(value, 3)
  }
}
