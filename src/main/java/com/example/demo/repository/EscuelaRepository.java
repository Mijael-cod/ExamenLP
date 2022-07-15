
package com.example.demo.repository;

import com.example.demo.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mijael
 */
@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Integer>{
    
    
}
