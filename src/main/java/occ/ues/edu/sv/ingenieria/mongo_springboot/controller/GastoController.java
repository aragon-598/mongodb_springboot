package occ.ues.edu.sv.ingenieria.mongo_springboot.controller;

import occ.ues.edu.sv.ingenieria.mongo_springboot.models.Gasto;
import occ.ues.edu.sv.ingenieria.mongo_springboot.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/gasto")
public class GastoController {

    @Autowired
    GastoService gastoService;

    @PostMapping("/nuevo")
    public ResponseEntity addGasto(@RequestBody Gasto gasto){
        gastoService.addGasto(gasto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit")
    public ResponseEntity updateGasto(@RequestBody Gasto gasto){
        gastoService.updateGasto(gasto);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity getAllGastos(){
        return ResponseEntity.ok(gastoService.getAllGastos());
    }

    @GetMapping("findByNombre/{nombre}")
    public ResponseEntity getGastoByNombre(@PathVariable String nombre){
        return ResponseEntity.ok(gastoService.getGastoByNombre(nombre));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteGasto(@PathVariable String id){
        gastoService.deleteGasto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
