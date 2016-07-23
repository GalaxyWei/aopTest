package holiday.aopTest.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Friends {
	@XStreamImplicit(itemFieldName="name")   //itemFieldName定义重复字段的名称，
    /*<friends>                               <friends>
        <name>A1</name>                         <String>A1</String>
        <name>A2</name>    如果没有，则会变成    =====>       <String>A1</String>
        <name>A3</name>                         <String>A1</String>
    </friends>                                </friends>
  */
    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}
