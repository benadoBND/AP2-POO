package br.com.ulbra.minhaapi.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>>  ListaTodosLivros(){
        return ResponseEntity.ok().body(this.bookService.ListaTodosLivro());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book>listaLivro(@PathVariable int id){
        return  ResponseEntity.ok(this.bookService.listaLivro(id));

    }
    @PostMapping
    public ResponseEntity<Book> criarNovoLivro(@RequestBody Book bookRequest){
        Book book = this.bookService.criarNovoLivro(bookRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(book);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable int id){
        this.bookService.deletarLivro(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> alterarLivro(@RequestBody Book bookRequest, @PathVariable int id){
        Book bookAtual = this.bookService.alterarLivro(bookRequest, id);
        return ResponseEntity.ok(bookAtual);
    }
}
