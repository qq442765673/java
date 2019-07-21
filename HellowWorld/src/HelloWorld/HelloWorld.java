package HelloWorld;

public class HelloWorld {
	int Dogage;
	public HelloWorld(String name) {
		
	}
	
	public void setAge(int age) {
		Dogage=age;
	}
	public void getAge() {
		System.out.print("Dog's age is:"+Dogage);
	}
    public static void main(String []args) {
    	HelloWorld myDog = new HelloWorld("afu");
    	myDog.setAge(3);
    	System.out.print("Dog's age is:"+myDog.Dogage);
    	myDog.getAge();
    }
}