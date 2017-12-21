package pl.com.booker.util.extensions

import java.util.*


fun <E> Stack<E>.popIfExist(): E? {
    if (empty().not()) {
        return pop()
    }
    return null
}


fun Date.fromUnixTimeStamp(timeStamp: Long): Date {
    time = (timeStamp as Long) * 1000
    return this
}

fun Date.getMonthNumber(): Int {
    val calendar = Calendar.getInstance()
    calendar.time = this

    return calendar.get(Calendar.MONTH) + 1
}
/*

fun Date.isFromLastMonth(): Boolean {
    return isLessThanXdays(30)
}

fun Date.isFromLastWeek(): Boolean {
    return isLessThanXdays(7)
}

private fun Date.isLessThanXdays(days: Int): Boolean {
    val days1 = Days.daysBetween(DateTime(this), DateTime()).days
    logd("", "days: $days1")
    return days1 <= days
}
*/

fun Date.differenceInDays(date: Date): Long {
    val today = Date()

    val diff = today.time - this.time

    return diff / (1000 * 60 * 60 * 24)
}