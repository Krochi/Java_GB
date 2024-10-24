import java.io.Serializable;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Person> familyMembers;

    public FamilyTree(List<Person> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public String toString() {
        return "FamilyTree{familyMembers=" + familyMembers + "}";
    }
}
