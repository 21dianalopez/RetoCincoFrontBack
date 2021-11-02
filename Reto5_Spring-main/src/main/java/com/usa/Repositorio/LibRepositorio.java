
package com.usa.Repositorio;

import com.usa.Interface.interfaceLib;
import com.usa.Modelo.Lib;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibRepositorio {
    
    @Autowired
    private interfaceLib crud;
    
    public List<Lib> getAll(){
        return (List<Lib>) crud.findAll();
    }
    
    public Optional<Lib> getLib(int id){
        return crud.findById(id);
    }
    
    public Lib save(Lib lib){
        return crud.save(lib);
    }
    
    public void delete(Lib lib){
        crud.delete(lib);
    }
}
