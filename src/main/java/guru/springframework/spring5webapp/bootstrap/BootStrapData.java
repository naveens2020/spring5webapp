package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("DC Books");
        publisher1.setCity("Kottayam");
        publisher1.setState("KL");

        publisherRepository.save(publisher1);

        System.out.println("Publisher Count: " + publisherRepository.count());
        Author naveen=new Author("Naveen","Sankar");
        Book book1=new Book("Testing","1234");
        naveen.getBooks().add(book1);
        book1.getAuthors().add(naveen);

        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        authorRepository.save(naveen);
        bookRepository.save(book1);

        Author Taara=new Author("Taara","Naveen");
        Book book2=new Book("Testing","1235677");
        Taara.getBooks().add(book2);
        book2.getAuthors().add(Taara);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(Taara);
        bookRepository.save(book2);

        System.out.println("Boot start started");
        System.out.println("No. of books: " + bookRepository.count());

    }
}
