interface BonusEligible {
    val bonusRate: Double
    fun calculateBonus(): Double = bonusRate * (this as Employee).calculateSalary()
}