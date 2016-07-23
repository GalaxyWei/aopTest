package holiday.aopTest.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pets {
	@XStreamImplicit(itemFieldName="pet")
    private List<Animal> animalList;
     
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
