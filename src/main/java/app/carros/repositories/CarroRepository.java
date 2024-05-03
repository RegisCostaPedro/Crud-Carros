package app.carros.repositories;

import app.carros.entities.Carro;
import app.carros.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    //Criar nome com a nomenclatura correta das classes e parâmetros
    public List<Carro> findByNome(String nome);



    public List<Carro> findByMarca(Marca marca);

    @Query("FROM Carro c  where c.ano > :ano")
    public List<Carro> findByAcimaAno(int ano);



}
