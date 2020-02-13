package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        //initialize map service and put an owner into it
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        Owner owner1 = Owner.builder().id(1L).address("testAdrress")
                .city("testCity").firstName("testFirstName").lastName("testLastName")
                .telephone("00").build();
        ownerMapService.save(owner1);
    }

    @Test
    void findAll() {
        Set<Owner> foundOwners = ownerMapService.findAll();
        assertEquals(1, foundOwners.size());
    }

    @Test
    void findById() {
        Owner foundOwner = ownerMapService.findById(1L);
        assertEquals(1L, foundOwner.getId());
    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerMapService.findByLastName("testLastName");
        assertNotNull(foundOwner);
        assertEquals(1L, foundOwner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner smith = ownerMapService.findByLastName("foo");
        assertNull(smith);
    }

    @Test
    void saveWithId() {
        Owner savedOwnerWithId = ownerMapService.save(Owner.builder().id(2L).build());
        assertEquals(2L, savedOwnerWithId.getId());
    }

    @Test
    void saveWithoutId() {
        Owner savedOwnerWithoutId = ownerMapService.save(Owner.builder().build());
        assertEquals(2, ownerMapService.findAll().size());
        assertNotNull(savedOwnerWithoutId);
        assertNotNull(savedOwnerWithoutId.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteByd() {
        ownerMapService.deleteById(1L);
        assertEquals(0, ownerMapService.findAll().size());
    }
}