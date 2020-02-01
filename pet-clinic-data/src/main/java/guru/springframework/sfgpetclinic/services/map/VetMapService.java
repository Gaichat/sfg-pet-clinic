package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialtyService;

    public VetMapService(SpecialityService specialtyService) {
        this.specialtyService = specialtyService;
    }

   /* public Vet save (Vet vet){
        if (vet != null){
            if (vet.getSpecialities().size()>0) {
                vet.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpecialty = specialtyService.save(speciality);
                        speciality.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(vet);
        }else{
            throw new RuntimeException("object cannot be null");
        }
    }*/
}
