package cl.uchile.dcc.citric
package model.norm

class Norma6Test extends munit.FunSuite {
  private var norma: Norma6 = _
  private var normaVI: Norma6 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new Norma6
    normaVI = new Norma6
  }

  test("Norma6 always give true"){
    val normaBoost1: Boolean = norma.checkBoost(1,200,0)
    assertEquals(normaBoost1,true)
    val normaBoost2: Boolean = normaVI.checkBoost(2, 0, 14)
    assertEquals(normaBoost2, true)
  }

  test("Norma6 should be able to stay at Norma6"){
    val finalNorma: Norma = norma.upgrade()
    assert(finalNorma.isInstanceOf[Norma6])
  }

  test("Norma6 give his value as an int") {
    val value: Int = norma.toNumber()
    assertEquals(value, 6)
  }
}
