package app.carros.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String modelo;
    private int ano;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("carros")
    @JsonBackReference
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="carro_proprietario")
    private List<Proprietario> proprietarios;

}
