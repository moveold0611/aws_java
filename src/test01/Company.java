package test01;

import lombok.AllArgsConstructor;
import lombok.Builder;


@AllArgsConstructor
@Builder
public class Company {
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;	
}
