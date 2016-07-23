package holiday.aopTest.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@XStreamAlias("phoneNumber")
public class PhoneNumber {
	@XStreamAlias("code")
    private int code;
    @XStreamAlias("number")
    private String number;
}
