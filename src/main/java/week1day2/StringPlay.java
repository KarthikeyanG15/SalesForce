package week1day2;

public class StringPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "3/8/2021";
		System.out.println("value"+text);
		String str[] = text.split("/");
		int day = Integer.parseInt(str[1])+1;
		text=str[0]+"/"+day+"/"+str[2];
		

	}

}
