package holiday.aopTest;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import holiday.aopTest.domain.Animal;
import holiday.aopTest.domain.Friends;
import holiday.aopTest.domain.Person;
import holiday.aopTest.domain.Pets;
import holiday.aopTest.domain.PhoneNumber;

public class XmlText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person per=new Person();
        per.setFirstName("chen");
        per.setLastName("youlong");
         
        PhoneNumber tel=new PhoneNumber();
        tel.setCode(137280);
        tel.setNumber("137280968");
         
        PhoneNumber fax=new PhoneNumber();
        fax.setCode(20);
        fax.setNumber("020221327");
        per.setTel(tel);
        per.setFax(fax);
         
         
        //测试一个标签下有多个同名标签
        List<String> friendList=new ArrayList<>();
        friendList.add("A1");
        friendList.add("A2");
        friendList.add("A3");
        Friends friend1=new Friends();
        friend1.setName(friendList);
        per.setFriend(friend1);
         
        //测试一个标签下循环对象
        Animal dog=new Animal("Dolly",2);
        Animal cat=new Animal("Ketty",2);
        List<Animal> petList=new ArrayList<>();
        petList.add(dog);
        petList.add(cat);
        Pets pet=new Pets();
        pet.setAnimalList(petList);
        per.setPet(pet);
        
        XStream xStream = new XStream();
        xStream.processAnnotations(Person.class);
        System.out.println(xStream.toXML(per));
	}

}
