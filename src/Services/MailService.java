package Services;

import Models.Book;
import Models.EBook;

public class MailService {
    public static void send(Book book, String email) {
        if(book instanceof EBook){
            EBook eBook = (EBook) book;
            System.out.println(
                    "[MailService] Sending eBook '" + eBook.getTitle() + "' (ISBN: " + eBook.getISBN() + ") as ." + eBook.getFileType() + " to email: " + email
            );
        }else{
            System.out.println("[MailService] Cannot send non-eBook to email: " + email);
        }
    }
}
