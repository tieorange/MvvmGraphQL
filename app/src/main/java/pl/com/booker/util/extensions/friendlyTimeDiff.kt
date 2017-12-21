package pl.com.booker.util.extensions

import java.util.*
import java.util.concurrent.TimeUnit

fun Date.friendlyTimeDiff(time1: Long, time2: Long): String {
    val stringBuffer = StringBuffer()
    val duration = time1 - time2

    val diffInHours = TimeUnit.MILLISECONDS.toHours(duration)
    if (diffInHours > 0) stringBuffer.append("$diffInHours godz.")
    else stringBuffer.append("0 godz.")

    /*val diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration)
    if (diffInMinutes > 0) stringBuffer.append("$diffInMinutes min.")
    else stringBuffer.append("0 min.")
*/
    /*val diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration)
    if (diffInSeconds > 0) stringBuffer.append("$diffInSeconds")
    else stringBuffer.append("0")*/

    return stringBuffer.toString()
}