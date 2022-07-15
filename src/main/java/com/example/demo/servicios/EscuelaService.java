
package com.example.demo.servicios;

import com.example.demo.entity.Escuela;
import com.example.demo.repository.EscuelaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mijael
 */
@Service
public class EscuelaService implements Operaciones<Escuela>{
    
    @Autowired
    private EscuelaRepository escuelaRepository;
    
    @Override
    public Escuela create(Escuela t) {
        return escuelaRepository.save(t);
        
    }

    @Override
    public Escuela update(Escuela t) {
        return escuelaRepository.save(t);
    }

    @Override
    public void delete(int id) {
        escuelaRepository.deleteById(id);
    }

    @Override
    public Escuela read(int id) {
        return escuelaRepository.findById(id).get();
    }

    @Override
    public List<Escuela> readAll() {
        return escuelaRepository.findAll();
    }
    
}
