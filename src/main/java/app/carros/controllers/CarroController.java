package app.carros.controllers;


import app.carros.entities.Carro;
import app.carros.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try {
            String mensagem = this.carroService.save(carro);
            return  new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String>  update(@RequestBody Carro carro,@PathVariable Long id){
        try {
            String mensagem = this.carroService.update(carro, id);
            return  new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  delete(@PathVariable Long id){
        try {
            String mensagem = this.carroService.delete(id);
            return  new ResponseEntity<>(mensagem, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public  ResponseEntity<List<Carro>> findAll(){
        try {
            List<Carro> carrosList = this.carroService.findAll();
            return  new ResponseEntity<>(carrosList, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro>  findById(@PathVariable Long id){
        try {
        Carro carro = this.carroService.findById(id);
        return  new ResponseEntity<Carro>(carro, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/findByNome")
    public ResponseEntity<List<Carro>>findByNome(@RequestParam String nome){
        try {
            List<Carro> carroList = this.carroService.findByNome(nome);
            return  new ResponseEntity<>(carroList, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam long idMarca){
        try {
            List<Carro> carroList = this.carroService.findByMarca(idMarca);
            return  new ResponseEntity<>(carroList, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }   @GetMapping("/findByAcimaAno")
    public ResponseEntity<List<Carro>> findByAcimaAno(@RequestParam int ano ){
        try {
            List<Carro> carroList = this.carroService.findByAcimaAno(ano);
            return  new ResponseEntity<>(carroList, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

