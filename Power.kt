import java.util.*;

fun main()
{
    val read=Scanner(System.`in`)
    val x=read.nextInt()
    val y=read.nextInt()
    var re=0;
    for(i in 1..x)
    {
        re+=y*x;
    }
    println(re)
}