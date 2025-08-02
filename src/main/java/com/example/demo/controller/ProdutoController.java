package com.example.demo.controller;

import com.example.demo.domain.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos(){
        List<Produto> produtos = service.listaTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable String id){
        Optional<Produto> optProduto = service.buscarPorId(id);

        if(optProduto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optProduto.get());
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        Produto novoProduto = service.salvar(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> alterar(@RequestBody Produto produto){
        Produto produtoAlterado = service.salvar(produto);
        return ResponseEntity.ok(produtoAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
