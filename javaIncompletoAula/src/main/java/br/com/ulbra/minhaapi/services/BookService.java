package br.com.ulbra.minhaapi.services;

import br.com.ulbra.minhaapi.models.Book;
import br.com.ulbra.minhaapi.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> ListaTodosLivros(){
        return this.bookRepository.ListaTodosLivros();

    }


    public Book listaLivro( int id){
        return this.bookRepository.listaLivro(id);

    }

    public Book criarNovoLivro( Book book){
        return this.bookRepository.criarNovoLivro(book);
    }

    public void deletarLivro( int id){
        this.bookRepository.deletarLivro(id);
    }


    public Book alterarLivro(Book bookRequest, int id){
        return this.bookRepository.(bookRequest, id);

    }
}
