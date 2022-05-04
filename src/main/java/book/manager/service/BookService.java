package book.manager.service;

import book.manager.entity.Book;
import book.manager.entity.BorrowDetails;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();

    List<Book> getAllBorrowedBookById(int id);

    List<Book> getAllBookWithOutBorrow();

    void deleteBook(int bid);

    void addBook(String title,String desc,double price);

    void borrowBook(int bid,int id);

    void returnBook(int bid,int id);

    List<BorrowDetails> getBorrowDetailsList();
}
