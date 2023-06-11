package TaasheeTraining.controller;

public class Instructor {
				String name;
				int id;
				String city;
				int age;
				public Instructor() {
					super();
					// TODO Auto-generated constructor stub
				}
				public Instructor(String name, int id, String city, int age) {
					super();
					this.name = name;
					this.id = id;
					this.city = city;
					this.age = age;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public int getId() {
					return id;
				}
				public void setId(int id) {
					this.id = id;
				}
				public String getCity() {
					return city;
				}
				public void setCity(String city) {
					this.city = city;
				}
				public int getAge() {
					return age;
				}
				public void setAge(int age) {
					this.age = age;
				}
				
				
}
