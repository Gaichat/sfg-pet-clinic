package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        //TO-DO
       return null;
    }
}
