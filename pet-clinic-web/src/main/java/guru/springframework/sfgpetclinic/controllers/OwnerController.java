package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listVets(Model model){
        Set<Owner> list = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setFirstName("toto");
        list.add(owner1);
        System.out.println(ownerService.findAll().size());
        System.out.println(ownerService.findById(1L).getFirstName());
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
