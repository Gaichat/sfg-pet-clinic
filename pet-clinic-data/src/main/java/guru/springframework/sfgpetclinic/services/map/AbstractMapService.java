package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T extends BaseEntity , ID extends Long > {

    protected Map<Long,T> map = new HashMap<>();


    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }


    public T findById(ID id){
        return map.get(id);
    }


    public T save(T object){
        if (object == null){
            throw new RuntimeException("object cannot be null");
        }
        if (object.getId() == null){
            object.setId(getNextId());
        }
        map.put(object.getId(),object);
        return map.get(object.getId());
    }


    public void deleteById(ID id){
        map.remove(id);
    }


    public void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        if (map.size()==0){
            nextId = 1L;
        }else {
            nextId = map.size() + 1L;
        }
        return nextId;
    }

}
