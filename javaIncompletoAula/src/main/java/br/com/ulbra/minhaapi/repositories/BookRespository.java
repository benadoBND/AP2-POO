package br.com.ulbra.minhaapi.repositories;

import br.com.ulbra.minhaapi.models.Book;
import br.com.ulbra.minhaapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<Book> books = new ArrayList<>();

    public void BookRepository() {
        books.add(new Book(1, "As longas tranças de um careca", "Careca", 1999 ));
        books.add(new Book(1, "A careca de um cabeludo", "Cabeludo", 1995 ));
        books.add(new Book(1, "Minecraft o CRIME", "Rezendevel", 1919 ));
    }


    public List<Book>  ListaTodosLivros(){
        return book;
    }


    public Book listaLivro(int id){
        return  books.stream().filter(item->item.getId()== id).findFirst().orElseThrow();

    }

    public Book criarNovoLivro( Book book){
        this.books.add();
        return book;
    }

    public void deletarLivro( int id){
        Book userFiltrado = books.stream().filter(item->item.getId()== id).findFirst().orElseThrow();
        books.remove(userFiltrado);
    }


    public Book alterarLivro(Book bookRequest, int id){
        Book userFiltrado = books.stream().filter(item->item.getId()== id).findFirst().orElseThrow();
        books.remove(userFiltrado);


        bookRequest.setId(userFiltrado.getId());
        int index = books.indexOf(userFiltrado);

        books.set(index, bookRequest);

        return bookRequest;
    }
}
