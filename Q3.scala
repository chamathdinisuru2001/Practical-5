object fibonacci{
    def fibonacci(n:Int):Int = n match{
        case 0 => 0
        case x if x==1 => 1
        case _ => fibonacci(n-1) + fibonacci(n-2)
    }

    def fibbonacciSeries(n:Int):Unit ={
        if(n>0) fibbonacciSeries(n-1)
        print(fibonacci(n)+s" ")
    }
    def main(args: Array[String]):Unit ={
        import scala.io.StdIn.readLine

        println("Enter a number:")
        val n = readLine().toInt
        fibbonacciSeries(n)
    }
}