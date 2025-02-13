import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class TaxCalculatorSpec extends AnyWordSpec {

  val taxCalculator: TaxCalculator = new TaxCalculator

  // I've done the first test for you!
  "TaxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is below the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(5000)

        assert(result == 0)
      }

      "the income is within the basic rate" in {
        val result: Double = taxCalculator.calculateTax(20000)
        assert(result == (20000 - 10000) * 0.2)
      }

      "the income is within the higher rate" in {
        val result: Double = taxCalculator.calculateTax(60000)
        assert(result == ((50000 - 10000) * 0.2) + (60000 - 50000) * 0.4)
      }

      "the income is in the additional rate" in {
        val result: Double = taxCalculator.calculateTax(126000)
        assert((result == ((50000 - 10000) * 0.2) + (125000 - 50000) * 0.4 + (126000 - 125000) * 0.45))
      }
    }

  }

  "TaxCalculator.IsHigherRateTaxpayer" should {
    "be true if income is above basic rate limit" in {
      assert(taxCalculator.isHigherRateTaxpayer(60000) == true)
    }

    "be false if income is lower than basic rate limit" in {
      assert(taxCalculator.isHigherRateTaxpayer(40000) == false)
    }
  }


}
