import java.util.*;

fun main()
{
    /**
    * if it is printed it will produce a number which is converted into currency
    */
    println(20000.toCurrency())
}


/**
 * @param [Any] will be convert to currency IDR
 * @return Rp.[Any]
 */
fun Any?.toCurrency(): String {
    val cleanString = (this ?: "").toString().replace(Regex("[^0-9]"), "")
    val parsed = cleanString.toBigDecimalOrNull() ?: 0.toBigDecimal()
    return NumberFormat.getCurrencyInstance(Locale("id", "id")).format((parsed)).removeSuffix(",00")
}