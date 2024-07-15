object  InventoryManagement{
    import scala.io.StdIn.readLine

    def getProductsList: List[String] = {
        def getProductsListRec(products: List[String]):List[String] ={
            val product = readLine("Enter the product names (type 'done' at the end): ")
            if (product.toLowerCase == "done") {
                products
            }else{
                getProductsListRec(products :+ product)
            }
        }
        getProductsListRec(List())
    }
    
    def printProductList(products: List[String]): Unit = {
        products.zipWithIndex.foreach{ case (product,index) =>
            println(s"${index+1}.$product")
        }
    }

    def getTotalProducts(products: List[String]): Int ={
        products.length
    }

    def main(args: Array[String]): Unit = {
        val productList = getProductsList
        println("\nProduct List: ")
        printProductList(productList)
        println(s"\nTotal number of products in the list: ${getTotalProducts(productList)}")
    }
}