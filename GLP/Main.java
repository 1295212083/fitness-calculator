package GLP;


public class Main {
public static void main(String[]args) {
	functionGL gl=new functionGL();
	double weight=48;
	double height=167.0;
	int age=21;
	int sex=0;
	String result=gl.BMI_Calculator(height);
	//System.out.println("The Ideal Weight for a "+height+"cm Person is: "+result+" kg.");
	double result2=gl.BMR_Calculator(weight,height,age,sex);
	//System.out.println("The BMR is "+result2+" Cal");
	
}
}
