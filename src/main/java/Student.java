
//BEAN Class Student
public class Student {

	// Creating Instance Variables
	private String name;
	private String country;
	private int age;
	private int mobile;
/* we cant access these instance variables directly because they are private variables. these are accessible only with in the Student.java program
 * If we want to access those three (3) properties from outside the java program the one and only way we have is to call the public methods in the public methods if we call the getter methods we will be getting the data.
 * 		So we have to call the setter methods only.
 * 
 */
	
	public Student() {
		System.out.println("Inside default Constructor");
	} 
	
	//creating constructor for the instance variable mobile.
	public Student(String name, String country, int age) {
		super();
		System.out.println("Inside Parameterized Constructor");
		this.name = name;
		this.country = country;
		this.age = age;
	}

	// Creating setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Inside Setter method");
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	

}

/*
 * We first created the Bean Class named "Student".
 * 
 * Now, with in the student we add some Instance Variables like int age, String
 * name, String country.
 * 
 * Now, we create Getters and Setters.
 * 
 * Here, if we observe Student is a class. Which is having three parameters name, country, age.
 * 		for each of the parameter/instance variable we have Setters and Getters methods.
 * 
 * Now, what we have to do ? We need to create the configuration file.
 * 
 * What will be folder structure of maven project?
 * 		Inside src/main/resources folder we will be creating "non java" files.
 * 		Coming to source folders we will be finding total 4 source folders.
 * 			- src/main/java    (we will be giving main application related java program files)
 * 			- src/main/resources (we will be adding non java related files like any xml file, properties file etc...)
 * 			- src/test/java		(we will be giving test related files.)
 * 			- src/test/resources
 *  
 * Now, let's create a Spring Bean configuration file in src/main/resources
 * 	In spring.xml, <beans> </beans> => these are called elements
 * 					xmlns => this is called an attribute and it is having an value 
 * 						"xmlns = "http://www.springframework.org/schema/beans" "
 * 	
 * Under, <beans> </beans>(parent tag) element we have to go for adding one "<bean> </bean>" object here.
 * <bean> object will be expecting the "name" and class name which the name is indicating, we can give any name here like "b1".
 * 				ex: <bean name = "b1" class ="Student">
 * 
 * So, now what we have done? within the spring.xml file with in the <beans> root tag we have added 1 <bean> tag here.
 * 
 * If we compare/convert the same xml file into java right, it will be something like creating an object for the class "Student" with the name = "b1" .
 * 
 * Whenever, we find a bean tag in the spring.xml related configuration file you have to understand that you are letting the spring create an object for that particular class(Student).
 *  
 * If we give like this,  <bean name = "b1" class ="Student">			  </bean>    internally the spring container will be creating an object for the "Student" class. 
 * 		Entire Spring is something like it will be like we will be preparing some "Ready To Use Objects here".
 * 
 * What do you mean by "Ready To Use Object"? Internally it will be creating an object(the SPring Container will be creating an object). So, that we can use it wherever it is needed.
 * 			But if we want we can create the object right? So, what is meant by "ReadyTo Use Object"?
 * 				If we consider a class "Student", within the Student class how many instance variables do we have? 3 (name, country, age)
 * 					-> for name we have setName and getName, for country we have setCountry and getCountry, for age we have setAge and getAge this is something like "Java Terminology".
 * 
 * If we convert the same thing to spring "Spring will be considering the class as a "dependents" and inside the class we have some(3: name, country, age) instance variables are there right? we will be considering them as "dependencies".
 * 
 * So, if we have the student object alone what will be default value of name and country, age ? it will be Null.
 * 			If it is an integer the default value will be "0", if it is a string the default value will be "Null".
 * 
 * So, now my requirement is i don't want to get an object which is having default values of Instance variables.
 * 		I want to get an object having content with the instance variables. what should we do?
 * 
 * Coming, to Student.java what are the instance variables ? name, country, age 
 * 		So, within the bean what we are trying to do is "we are trying to create one property tag"	it expects "name" and "value".
 * ex: <property name = "name" value ="EGiants"/> 
 * 		<property name = "country" value="India"/>
 * 		<property name = "age" value="23"/>         (so, here we are mentioning that something like setting the values for those 3 properties "name, country, age".
 * 	So, what exactly is happening when we set the property tags like this? we are setting the values for the name, country, age.
 * 
 * So, now let's just observe the Student.java program. If we want to set the values manually through java programming how can i set the value for name, country, age?
 * 				ans: by just passing the value to setter methods.
 * 	If we want to set the value we will be simply calling the "setter methods". 
 * 		first: We will be creating the student object first by default that object contains "Null" values. So, to change the values we will be calling setName, setCountry, setAge.
 * 
 * In Java, The one and only way to pass the values for (name, country, age) in Student.java programs is to call the "setter" methods.
 * 	
 * Coming, to spring.xml can i expect giving the property tags like this will be internally converting into "setter" method calls. 
 * 		yes, internally it will be taking them as setter method calls, its kind of mapping type.
 * 
 * So, whenever we are giving the property tag within the spring.xml configuration file, internally it will be converted into setter method calls.
 * 		So, how it will be taking the setter methods means "here it will be taking property names (the property names should be exactly same as in the Student.java file) so that internally it will be adding set as prefix for the same instance varibales.
 * 			ex: when we give country in the property name tag, internally it will be trying to call setCountry(value).
 * 
 * In, future if we are giving any new property <property name="ABC" Value = "XYZ" /> , internally it will be calling it as setABC("XYZ");
 * 
 * ****Whenever we are giving a "Property tag" internally it will be calling a "Setter method".
 * 
 * So, now we have our Student.Java file and Spring.xml file. let's write a main java file.
 * 
 * 
 * 
 */

























