package dataprovider;

import org.testng.annotations.DataProvider;

public class Data_Providers 

{
	@DataProvider(name="InvalidCredentials")
	public Object[][] verify_User_Credencial_Data()
	{
	Object[][] data=new Object[3][2];
	data[0][0]="aadmiim";
	data[0][1]="123456";
	
	data[1][0]="admin";
	data[1][1]="112233";
	
	data[2][0]="aaaddm";
	data[2][1]="44444444";
    return data;
	}

}
