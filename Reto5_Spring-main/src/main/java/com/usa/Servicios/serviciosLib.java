
package com.usa.Servicios;

import com.usa.Modelo.Lib;
import com.usa.Repositorio.LibRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosLib {
    
    @Autowired
    private LibRepositorio metodosCrud;
    
    public List<Lib> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Lib> getLib(int id){
        return metodosCrud.getLib(id);
    }
    
    public Lib save(Lib lib){
        if(lib.getId()==null){
            return metodosCrud.save(lib);
        }else{
            Optional<Lib> evt=metodosCrud.getLib(lib.getId());
            if(evt.isEmpty()){
               return metodosCrud.save(lib);
            }else{
                return lib;
            }
        }
    }
    
    public Lib update(Lib lib){
        if (lib.getId()!=null){
            Optional<Lib> evt = metodosCrud.getLib(lib.getId());
            if (!evt.isEmpty()){
                if (lib.getName()!=null){
                    evt.get().setName(lib.getName());
                }
                if (lib.getTarget()!=null){
                    evt.get().setTarget(lib.getTarget());
                }
                if (lib.getCapacity()!=null){
                    evt.get().setCapacity(lib.getCapacity());
                }
                if (lib.getDescription()!=null){
                    evt.get().setDescription(lib.getDescription());
                }
                if (lib.getCategory()!=null){
                    evt.get().setCategory(lib.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else {
                return lib;
            }
        }else {
            return lib;
        }
    }
    
    public boolean deleteLib(int id){
        Boolean del = getLib(id).map(lib -> {
            metodosCrud.delete(lib);
            return true;
        }).orElse(false);
        return del;
    }
}
