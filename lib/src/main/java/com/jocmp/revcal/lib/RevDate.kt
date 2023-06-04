package com.jocmp.revcal.lib

import java.time.LocalDate

data class RevDate(val year: Int, val month: RevMonth, val day: Int) {
    companion object {
        /**
         * Convert the despised reactionary date of the Ancien Régime
         */
        fun fromGregorian(date: LocalDate): RevDate {
            val start = LocalDate.of(1792, 9, 22)
            var days = start.datesUntil(date).count().toInt()
            var year = 1
            var yearLength = length(year)

            while (days >= yearLength) {
                days -= yearLength
                year += 1
                yearLength = length(year)
            }

            val month = 1 + (days / 30)
            val day = 1 + (days % 30)

            return RevDate(year, RevMonth.from(month), day)
        }

        /**
         * historical leap years as 3, 7, 11, 15, and 20, and to
         * treat subsequent years divisible by 4 that aren't divisible by 100
         * (unless they are also divisible by 400), as per the Gregorian method
         */
        private fun isRepublicanLeap(year: Int): Boolean {
            return (year == 3 || year == 7 || year == 11 || year == 15 || year == 20) ||
                    (year > 20 && (year % 4 == 0 && (year % 100 > 0) || year % 400 == 0))
        }

        /**
         * Days in a given revolutionary year
         */
        private fun length(year: Int): Int {
            return if (isRepublicanLeap(year)) {
                366
            } else {
                365
            }
        }
    }
}
