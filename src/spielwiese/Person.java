package spielwiese;

public class Person {

	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public static void main(String args[]) {
		Person person1 = new Person("Peter");
		Person person2 = new Person("Peter");
		
		System.out.println(person1.equals(person2));
	}
	
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person anderePerson = (Person) obj;
		
		return anderePerson.name.equals(name);
	}
		
}
