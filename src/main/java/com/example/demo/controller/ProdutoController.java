package com.example.demo.controller;

import com.example.demo.domain.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listarTodos(){
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable String id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable String id){
        service.delete(id);
    }

}
