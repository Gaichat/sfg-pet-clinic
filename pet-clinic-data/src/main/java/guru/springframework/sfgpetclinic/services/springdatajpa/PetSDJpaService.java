package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(("springdatajpa"))
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    private final OwnerRepository ownerRepository;
    private final VisitRepository visitRepository;

    public PetSDJpaService(PetRepository petRepository,
                           PetTypeRepository petTypeRepository,
                           OwnerRepository ownerRepository,
                           VisitRepository visitRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.ownerRepository = ownerRepository;
        this.visitRepository = visitRepository;
    }


    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
