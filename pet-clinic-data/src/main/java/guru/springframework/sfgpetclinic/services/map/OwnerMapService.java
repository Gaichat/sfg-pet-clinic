package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;


@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService = new PetTypeMapService();
    private final PetMapService petService = new PetMapService();

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {

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
                            System.out.println("toto");
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("PetType is required !!!");
                    }
                    if(pet.getId()==null){
                        System.out.println("titi");
                        Pet savedPet = petService.save(pet);
                        System.out.println(savedPet);
                        //pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        }else{
            return null;
        }
    }

}
