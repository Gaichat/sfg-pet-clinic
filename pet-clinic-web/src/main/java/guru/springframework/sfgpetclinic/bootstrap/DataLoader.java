package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;

    public DataLoader(){
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("luna");
        owner1.setLastName("jolie");
        owner1.setId(1L);
        ownerService.save(owner1,1L);

        Owner owner2 = new Owner();
        owner1.setFirstName("josé");
        owner1.setLastName("pantoufle");
        owner1.setId(2L);
        ownerService.save(owner2,2L);

        Vet vet1 = new Vet();
        owner1.setFirstName("Dr");
        owner1.setLastName("Poil");
        owner1.setId(1L);
        vetService.save(vet1,1L);

        Vet vet2 = new Vet();
        owner1.setFirstName("Dr");
        owner1.setLastName("Canine");
        vetService.save(vet2,2L);
    }
}
