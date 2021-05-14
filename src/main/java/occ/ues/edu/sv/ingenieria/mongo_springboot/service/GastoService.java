package occ.ues.edu.sv.ingenieria.mongo_springboot.service;

import occ.ues.edu.sv.ingenieria.mongo_springboot.models.Gasto;
import occ.ues.edu.sv.ingenieria.mongo_springboot.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GastoService {

    @Autowired
    GastoRepository gastoRepository;

    public void addGasto(Gasto gasto){
        gastoRepository.insert(gasto);
    }
    public void updateGasto(Gasto gasto){
        Gasto existente = gastoRepository.findById(gasto.getId()).orElseThrow(()-> new RuntimeException(
                String.format("No se encontró el gasto con ID %s",gasto.getId())
        ));
        existente.setNombreGasto(gasto.getNombreGasto());
        existente.setGastoCategoria(gasto.getGastoCategoria());
        existente.setTotalGasto(gasto.getTotalGasto());

        gastoRepository.save(existente);
    }

    public ArrayList<Gasto> getAllGastos(){
        return (ArrayList<Gasto>)gastoRepository.findAll();
    }

    public Gasto getGastoByNombre(String nombre){
         return gastoRepository.findByNombre(nombre).orElseThrow(
                 ()-> new RuntimeException(String.format("Gasto no encontrado con el nombre %s",nombre))
         );
    }

    public void deleteGasto(String id){
        gastoRepository.deleteById(id);
    }
}
