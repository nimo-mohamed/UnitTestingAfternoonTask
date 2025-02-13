class TaxCalculator {

  // Tax bands (simplified to make testing a bit easier)
  private val personalAllowance: Int = 10000
  private val basicRateLimit: Int = 50000
  private val higherRateLimit: Int = 125000

  // Tax rates
  private val personalAllowanceRate: Double = 0
  private val basicRate: Double = 0.2
  private val higherRate: Double = 0.4
  private val additionalRate: Double = 0.45

  /** how tax works:
   * -  Up to £10,000 → No tax (0%)
   * - £10,001 - £50,000 → 20% tax on the portion above £10,000.
   * - £50,001 - £125,000 → 40% tax on the portion above £50,000.
   * - Above £125,000 → 45% tax on the portion above £125,000. */

  // A method to calculate the total amount of tax to be paid, returned as a double
  def calculateTax(income: Double): Double = {
    if (income <= personalAllowance) {
      0 // no tax
    } else if (income <= basicRateLimit) {
      (income - personalAllowance) * basicRate
    } else if (income <= higherRateLimit) {
      ((basicRateLimit - personalAllowance) * basicRate) + ((income - basicRateLimit) * higherRate)
    } else {
      ((basicRateLimit - personalAllowance) * basicRate) +
        ((higherRateLimit - basicRateLimit) * higherRate) +
        ((income - higherRateLimit) * additionalRate)
    }
  }


  // A method which can tell you if someone is a higher rate taxpayer
  def isHigherRateTaxpayer(income: Double): Boolean = {
    income > basicRateLimit
  }



  //// A method that will return a string with the income limit of their current tax band.
  //// The return will also be formatted, E.g: "£12,500" or "No limit"
  //def formattedCurrentTaxAllowance(income: Double): String = {
  //  ???
  //}
}

