
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mijael
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "escuela")
@Entity
public class Escuela implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idescuela;
    @Column(unique=true)
    private String nombre; 
    private int estudiantes;
    private String jalados;
    private int notas;
    

}
