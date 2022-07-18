package com.example.demo.servicios;

import com.example.demo.entity.Pedido;
import com.example.demo.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService implements Operaciones<Pedido>{
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Override
    public Pedido create(Pedido t) {
        return pedidoRepository.save(t);
        
    }

    @Override
    public Pedido update(Pedido t) {
        return pedidoRepository.save(t);
    }

    @Override
    public void delete(int id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido read(int id) {
        return pedidoRepository.findById(id).get();
    }

    @Override
    public List<Pedido> readAll() {
        return pedidoRepository.findAll();
    }
    
}
