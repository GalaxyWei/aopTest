package holiday.aopTest.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XStreamAlias("person")
public class Person {
	@XStreamAlias("firstName")
    private String firstName;
    @XStreamAlias("lastName")
    private String lastName;
     
    @XStreamAlias("telphone")
    private PhoneNumber tel;
    @XStreamAlias("faxphone")
    private PhoneNumber fax;
     
    //测试一个标签下有多个同名标签
    @XStreamAlias("friends")
    private Friends friend;
     
    //测试一个标签下循环对象
    @XStreamAlias("pets")
    private Pets pet;
    
    
}
