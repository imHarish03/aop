package lab.demo.spring.aop.model;

public class Account {
	private int id;
	private String name;

	public Account() {

	}

	public Account(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		System.out.println("Getter Id- " + id);
		return id;
	}

	public void setId(int id) {
		System.out.println("Setter id: " + id);
		this.id = id;
	}

	public String getName() {
		System.out.println("Getter name- " + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("Setter name: " + name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}

}
