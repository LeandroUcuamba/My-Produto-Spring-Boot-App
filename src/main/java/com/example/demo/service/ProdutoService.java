package com.example.demo.service;

import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listaTodos() {
        return (List<Produto>) repository.findAll();
    }

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Optional<Produto> buscarPorId(String id) {
        return repository.findById(id);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
