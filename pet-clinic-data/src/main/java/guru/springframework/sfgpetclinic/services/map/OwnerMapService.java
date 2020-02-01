package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Owner findByLastName(String lastName) {
        //TO-DO
       return null;
    }

    @Override
    public Owner save(Owner owner){
        if (owner != null){
            if(owner.getPets() != null){
                owner.getPets().forEach( pet ->{
                    if (pet.getPetType()!= null){
                        if (pet.getPetType().getId()== null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("PetType is required !!!");
                    }
                    if(pet.getId()==null){
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(owner);
        }else{
            return null;
        }
    }

}
