package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0 ){
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Load data....");

        PetType catType = new PetType();
        catType.setTypeName("Cat");
        petTypeService.save(catType);

        PetType dogType = new PetType();
        dogType.setTypeName("Dog");
        petTypeService.save(dogType);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("luna");
        owner1.setLastName("jolie");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(dogType);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setName("Rosco");
        owner1.getPets().add(owner1Pet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("josé");
        owner2.setLastName("pantoufle");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet owner2Cat = new Pet();
        owner2Cat.setName("Just Cat");
        owner2Cat.setOwner(owner2);
        owner2Cat.setBirthDate(LocalDate.now());
        owner2Cat.setPetType(catType);
        owner2.getPets().add(owner2Cat);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Dr");
        vet1.setLastName("Poil");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr");
        vet2.setLastName("Canine");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
    }
}
