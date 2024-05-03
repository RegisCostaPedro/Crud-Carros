package app.carros.services;

import app.carros.entities.Carro;
import app.carros.entities.Marca;
import app.carros.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;
    public String save(Carro carro){

      this.carroRepository.save(carro);
        return carro.getNome() + " Carro salvo com sucesso!";
    }

    public String update(Carro carro, Long id){
        carro.setId(id);
        this.carroRepository.save(carro);
        return carro.getNome() + " Carro atualizado com sucesso";
    }
    public String delete( Long id){

        this.carroRepository.deleteById(id);
        return " Carro deletado com sucesso";
    }

    public List<Carro> findAll(){
     List<Carro> carrosList =  this.carroRepository.findAll();
     return  carrosList;
    }
    public Carro findById(Long id){
     Carro carro = this.carroRepository.findById(id).get();
     return carro;
    }

    public List<Carro> findByNome(String nome){
        return this.carroRepository.findByNome(nome);

    }
    public List<Carro> findByMarca(long idMarca){
        var marca = new Marca();
        marca.setId(idMarca);
        return this.carroRepository.findByMarca(marca);

    }
    public List<Carro> findByAcimaAno(int ano){

        return this.carroRepository.findByAcimaAno(ano);

    }

}
