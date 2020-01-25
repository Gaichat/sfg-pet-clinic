package guru.springframework.sfgpetclinic.model;

public class PetType extends BaseEntity{
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
