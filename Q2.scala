object LibraryManagement{
    case class Book(title: String, author: String, isbn: String)

    var library: Set[Book] = Set(
        Book("Madolduwa", "Martin Wickramasinghe", "1111111111"),
    Book("Harry Potter", "J.K. Rowling", "2222222222"),
    Book("Dune", "Frank Herbert", "3333333333"),
    Book("Oliver Twist", "Charles Dickens", "4444444444"),
    Book("Sherlock Holmes", "Arthur Conan Doyle", "5555555555"),
    Book("Game of Thrones", "George R.R. Martin", "6666666666")
    )

    def addBook(book: Book):Unit={
        library += book
        println(s"Book '${book.title}' added to the library")
    }

    def removeBook(isbn:String): Unit ={
        val bookOption = library.find(_.isbn == isbn)
        bookOption match{
            case Some(book) =>
                library -= book
                println(s"Book '${book.title}' removed from the library.")
            case None => 
                println(s"No such book found in the library") 
        }
    }

    def isBookInLibrary(isbn: String): Boolean ={
        library.exists(_.isbn == isbn)
    }

    def displayLibrary(): Unit ={
        println("Current library collection: ")
        library.foreach{ book =>
            println(s"Title: ${book.title},Author: ${book.author},ISBN: ${book.isbn}")
        }
    }

    def searchByTitle(title: String):Unit ={
        val bookOption = library.find(_.title.equalsIgnoreCase(title))
        bookOption match{
            case Some(book) =>
                println(s"Book '${book.title}'- Author: ${book.author},ISBN: ${book.isbn}.")
            case None =>
                println(s"No book found with title '$title'")
        }
    }

    def searchByAuthor(author: String):Unit ={
        val bookByAuthor = library.filter(_.author.equalsIgnoreCase(author))
        if(bookByAuthor.nonEmpty){
            println(s"Book by author '$author': ")
            bookByAuthor.foreach{ book =>
                println(s"Title: ${book.title}, ISBN: ${book.isbn}")
            }
        }else{
            println(s"No books by author '$author.")
        }
    }

    def main(args: Array[String]): Unit = {
        import scala.io.StdIn.readLine

        var continue = true

        while (continue) {
            println("\nLibrary Management System")
            println("1. Display Library Collection")
            println("2. Add a Book")
            println("3. Remove a Book")
            println("4. Check if a Book is in the Library")
            println("5. Search for a Book by Title")
            println("6. Display Books by Author")
            println("7. Exit")
            print("Choose an option: ")
            val choice = readLine().toInt

            choice match {
                case 1 =>
                    displayLibrary()
                case 2 =>
                    print("Enter book title: ")
                    val title = readLine()
                    print("Enter book author: ")
                    val author = readLine()
                    print("Enter book ISBN: ")
                    val isbn = readLine()
                    addBook(Book(title, author, isbn))
                case 3 =>
                    print("Enter book ISBN to remove: ")
                    val isbn = readLine()
                    removeBook(isbn)
                case 4 =>
                    print("Enter book ISBN to check: ")
                    val isbn = readLine()
                    println(s"Is the book in the library? ${isBookInLibrary(isbn)}")
                case 5 =>
                    print("Enter book title to search: ")
                    val title = readLine()
                    searchByTitle(title)
                case 6 =>
                    print("Enter author to display books: ")
                    val author = readLine()
                    searchByAuthor(author)
                case 7 =>
                    continue = false
                case _ =>
                    println("Invalid option. Please try again.")
            }
        }
    }
}
