package holiday.aopTest.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Animal {
	@XStreamAlias("name")
    private String name;
    @XStreamAlias("age")
    private int age;
    public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
}
