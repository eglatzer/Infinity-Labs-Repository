package com.ilad.printobject;

public class MainTest {

	public static void main(String[] args) {
		int[] idNumbers = {123456789, 456789012, 789012345};
		Name[] names = new Name[3];
		names[0] = new Name("Glatzer", "Evyatar");
		names[1] = new Name("Talmor", "Asaf");
		names[2] = new Name("Grinboim", "Dina");
		Date[] datesOfBirth = new Date[3];
		datesOfBirth[0] = new Date(17, 10, 1983);
		datesOfBirth[1] = new Date(3, 4, 1979);
		datesOfBirth[2] = new Date(5, 10, 1993);
		Person.Sex[] sexes = new Person.Sex[3];
		sexes[0] = Person.Sex.MALE;
		sexes[1] = Person.Sex.MALE;
		sexes[2] = Person.Sex.FEMALE;
		
		Person[] persons = new Person[3];
		for(int i = 0; i < 3; ++i) {
			persons[i] =
					new Person(idNumbers[i], names[i], datesOfBirth[i], sexes[i]);
		}
		
		PrintObject.print(persons);
	}
}