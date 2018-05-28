//Bean Factory is an interface here.
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;



public class Application {

	public static void main(String[] args) {
		
		//Creating an beanfactory object. "Bean factory" is an interface here.
		//So, in this project we are gonna use "ClasspathXmlApplicationContext" class file. So, this is a non-abstract class.
			//If it is an non-abstract class means what we can do? we can create an object for this.
		BeanFactory  factory = new  ClassPathXmlApplicationContext("spring.xml");
		
		//Now, from the Bean Factory we need to fetch the bean now  
		Student st= (Student) factory.getBean("st"); //we are passing the bean id 
		
		//now lets, display the values here
		System.out.println("Name:" + st.getName() + "\n" + "Age:" + st.getAge() + "\n" + "Country:" + st.getCountry() + "\n" + "Mobile:" + st.getMobile());
		
		
		
	}
	
	
	
}


/*					***** Spring IOC (Inversion of Control ******
 * 
 *  Now, we are creating a main application java file or main class file.abstract. 
 * This is similar to the way we deal with hibernate only, 
 * 		1) we need to read the configuration file, here the configuration file is "Spring.xml". Where as in hibernate by default we will be having "hibernate.cfg.xml" as configuration file.
 * 				Here, we don't have any default file names or something like that. Most of the people will be giving "Spring-BeanConfiguration.xml" file  or "Application.xml file" something like that.
 * 					By, using this xml file what exactly we need to do is? we need to get the bean factory, from the bean factory we will be getting the bean.
 * 		
 * 			Creating Client Application:
 * 					-Bean Factory
 * 					-Beans
 * 			The beans which we have configured here is "Student.java". So, now we should be trying to get the same "Student.java" object from our bean factory.
 * 
 * Now, Let's create one BeanFactory object. So, here "BeanFactory" is an interface.
 * 	Since we identified that beanfactory is not a class it is an interface. 
 * 		So, finally we need to create an beanfactory object. what should we do? i need to get an instance for beanfactory.
 *sol: As beanfactory is an interface we can't create an object directly for that. Instead what we should do is "we need to use implemented classes here".
 * 		
 * There, are "n" number of implemented classes for beanfactory, 
 * 				but have two major implementation classes which we can use for beanfactory internally.
 * 									
 * 			1) ClassPathXmlApplicationContext
 * 			2) FileSystemXmlApplicationContext
 * XmlApplicationContext is same in both the classes. So, what is the difference between the two classes?
 * 
 * Here, coming to the configuration file if i am giving the configuration file in my src/main/resources it will be in my classpath right?
 *- Classpath is nothing but wherever the java program can access the locations by default. what are all the locations it can access by default?
 * 		it will be considered as a class path.
 *- If we are adding something in src/main/resources, see coming to the HibernateDemo "src/main/resources" we have added "hibernate.cfg.xml" and "student.hbm.xml" file. 
 * 		Coming to here in application.java we are directly giving cfg.configure and i am able to read hibernate.cfg.xml and student.hbm.xml.
 * 		we are not giving any default location for that. (we are  not giving any file/class path here) So, these type of locations will be called as classpath locations. 
 * 			So, whatever we are adding in src/main/resources it will be by default available to my java programs. So, that i can directly use it.
 * 		
 * 		ex: let's assume that hibernate.cfg.xml and student.hbm.xml files both are copied into some other location other than the src/main/resources then our program is unable to identify these two files since they are outside the project folder.
 * 				So, we need to explicitly mention the classpath here. (why because those two files are not in our classpath they are in ur machines file system).
 * 					So in Spirng also we need to do the same thing.  
 * 
 *- So, whatever the configuration files we have written are existing in your classpath then we will be using "ClassPathXmlApplicationContext".
 * 		if the configuration files are existing in some other c, d, e, f or any other drives then we will be using "FileSystemXmlApplicationContext".  
 * 
 *- So, in this project we are use "ClasspathXmlApplicationContext" class file. So, this is a non-abstract class.
 * 			If it is an non-abstract class means what we can do? we can create an object for this.
 * 
 *- If we create an object internally what will happen?I will be calling/executing the constructor.
 * 		So, in this "ClasspathXmlApplicationContext" we are gonna use the constructor for "configlocation".
 * 			"ClasspathXmlApplicationContext(jaav.lang.String.configLocation)
 * 
 *- Now, from the Bean Factory we need to fetch the bean. So, let's try to fetch the student object.
 * 		Student st = factory.getBean( so we can give the bean name or bean id we can give  );     
 * 			Since the getBean method return type is object, we are unable to store the object into the student variable. So we have to add the casting.
 * 
 *- So, Now using the get() methods we are printing all the name, age & country from spring.xml file as the o/p.
 *		Whatever data we have given in the configuration file, we are able to fetch the same data here.
 *
 *- Now, think in a big picture this not something like we have written it just to fetch the data in from the spring.xml not it's not for that.
 *		Our aim is not to fetch the data from these two properties tags.
 *			what exactly we have done is Internally whenever we are reading the spring.xml file right internally the beanfactory has already created objects for the beans which are configured in the bean configuration file.
 *				At the time of reading the spring.xml file itself internally the (Spring Container / the bean factory) is creating the objects for all the bean tags that are mentioned in the spring.xml and it is storing all these beans in the beanfactory.
 *- Now what we are trying to do, we are trying to utilize existing bean within the beanfactory and we are trying to simply fetch the data just to verify whether the data is "wired" properly to the proeprties or not.
 *		why we are calling getter methods is? we are just verifying the o/p is same as they are assigned in the spring.xml or not we are just verifying. If the data is wired properly or not we are verifying.
 *
 *-	So, the aim of this program is just to fetch the bean form the factory to verify if it is ready with the data or not.
 * 
 *- Understand the big picture, forget about Student.java and giving some values for the name and country and age. 
 *		So in the real scenario how this simple program will help us?
 *			- Giving control to spring to create the object.
 *			- In what sense we can use this kind of spring application?
 *			ans: Here, the thing is we are trying prepare some ready to use objects, 	
 *				In future what we can do? Instead of simply creating Student bean here.  We can create an class object here which is something related to Hibernate.
 *					So, here what is the bean object we are trying to create? I am trying to create a bean for the class student,
 *						May be in the future I can create one more bean which is used for hibernate or else I may create one more bean which is used to help me in the JDBC,
 *							It will become Spring+JDBC and Spring + Hibernate.
 *
 *- The over all view is coming to the entire spring. This is something like how we are configuring the bean. It doesn't matter which module we are using Spring MVC or Spring Hibernate or Spring Data(JDBC)/ Spring Struts it doesn't for you.
 *		It's a matter of configuring the bean to the container and using the bean in the application 
 *
 *- We can't simply give <property name = " school" > in the spring.xml file without mentioning that first in the POJO class file.	
 *		It will fail because internally the process is the property name = " school " will be converted into "setter method" but coming to POJO class we dont have that private String school; for the same. SO, obviously it's going to fail.
 *
 *-Whatever the property tags we are writing it should match with the property or with the instance variables in the class. 
 *		So, in the future what we will be doing is ex: we are trying to do SPring+data (spring + JDBC). 
 *			So, in spring + JDBC what exactly we will be doing is we need to identify what is the bean class that is used for creation of connection or may be for creation of statement something like that, that particular object we need to add in the spring.xml file as a bean.		
 *				and coming to the main method application we will be getting the bean from the bean factory and we will be calling the required method from that particular object.
 *
 *- So it doesn't matter whether we are using Spring + data or Spring + Hibernate it doesnt matter. So this is the core concept.
 *
 *
 *			********** Bean Factory is the Container here **********
 *						Bean Factory , Container everything is same.
 *
 *- So, we are adding the bean file into the container using the Client Application (in the application.java) file.
 *		Exactly, we are not doing that manually. who will be doing that means? bean factory itself is doing.
 *			ex: BeanFactory  factory = new  ClassPathXmlApplicationContext("spring.xml");
 * 				we are trying to create an object for the bean factory by using implementation class(ClassPathXmlApplicationContext) by passing the configuration file.
 * 
 * - As we are passing the configuration file what it is doing is? it is trying to read all the beans that are located in  that configuration file and it is trying to create those objects and it is keeping in the "bean factory or spring container(both are same)".
 * 		After that what we are doing, as the bean factory or container is having the objects we are trying to call the "getBean()" method to get those beans and we are using them.
 * 
 * - So, in the future what i am trying to mention is in the future instead of configuring the student class, we will be configuring some hibernate related class here or the JDBC related class here and we will be giving all the required properties for them, 
 *			and we will be trying to utilize the same thing in the Application.java application file. So, that we can directly embed the hibernate features here or else we can directly embed the JDBC features like that.
 *
 *- So, the tricky/main part here is "what are all the classes that we need to use as the part of Spring hibernate or what are all the classes that we need to use as part of the JDBC to identify those classes is the little tricky part.
 *		rest of the configuration is same, simply we will be adding one bean tag here and with in the bean tag we will be adding properties tag here. So, the properties tag will be calling the setter methods here internally creating an object for you and it will be preparing the object for you. that's it.
 * 
 * -************** It is very important to understand how the bean is converted into object internally. **********
 * 
 * - So, finally if we consider the class Student here, it is called "dependent" and the properties/parameters here name, country, age here are called "dependencies".
 * 			If we (want to use/are getting) the student object alone it doenst matter actually(it doenst make any sense) why beacuse we will be getting an empty object with name null and country null it's not at all going to make any sense for us. 
 * 				So if we are getting student object with some data it will be useful for us thats the reason by using properties tag which will be internally converted into setter methods. what we are doing ? we are trying to "Inject the Dependencies" here.
 * 
 * - Since, we are trying to Inject the Dependencies here so thats the reason we are calling it as "Dependency Injection" here:
 * 		Whatever we are doing now is called "Dependency Injection". If someone is asking you to explain what dependency injection means we have to talk about all these.
 * 
 * - So in simple words what is dependency injection means? is nothing but Initializing Instance variables.  
 * 	 		It's nothing but injecting the properties for dependencies, a dependency/dependencies is nothing but a instance variables.
 * 
 * 			*******So, in simpler form I can say Dependency Injection is nothing but Initializing Instance Variables **********
 * 
 * - In how many ways we can initialize instance variables?
 * 		So, coming to initialize instance variables either we can go for constructors  or we can go for setter methods.
 * 			When we create the object, for whom we will be passing the data? for constructors.
 * 
 * - So, here whatever the dependency "<property name ="name" value ="Gopal"/>" we are using here, what is that? 	 
 * 			So, that is Setter's dependency injection.
 * 
 * -  ******      There are a total of 2 ways for achieving dependency injections in spring:  ********
 * 						they are 1) Constructor Dependency Injection and 
 * 					 				2) Setter's dependency Injection. 
 * 
 * - Coming to us, whether it is constructor dependency injection or setter dependency injection it doesn't matter. why because what we will be doing? 
 * 		In the configuration file only we will be updating the data/tags.
 * 
 * - If we are giving the <property    > tags it will be calling the Setter methods. 
 * 			So, instead of that we can pass data through <constructor-arg   > which will call Constructor Injection methods.
 * 				Before passing the <constructor-arg  > make sure that u have passed constructor in the Student.java or any other POJO class files if youre gonna use "Constructor Dependency Injection".
 * 					This is something like creating a parameterized constructor and calling that. If we want to pass some data for the constructor first there should be a constructor existing here. 
 * 						So create constructor in the Student.java program and try to call the constructor from the spring.xml file.
 *   
 * 
 *- We can't access these instance variables directly because they are private variables. these are accessible only with in the Student.java program
 * 		If we want to access those three (3) properties from outside the java program the one and only way we have is to call the public methods. 
 * 			In the public methods if we call the getter methods we will be getting the data.
 * 				So we have to call the "setter methods" only.
 * 
 * - So, we never create the object manually. The bean tag "<bean    >" which we are providing does that.
 * 
 * - what exactly is happening in this particular area? in spring.xml
 * 		<bean id = "st" class ="Student"> <!--  we can give bean name or id, these id and class are for identifying the bean only. -->
      		<property name ="name" value ="Gopal"/> 
 			<property name ="country" value="India"/>  <!--  internally it will be trying to call setCountry(value) -->
 			<property name ="age" value="23"/> 
  		</bean>				
 * 	"It's going to create an object for the student class, if it is creating an object internally what will happen? it's going to call an constructor. which constructor it will execute? the default constructor.
 * 		After that what it will be doing? it going to call the setter methods internally, to assign the data/values to the instance variables."
 * 
 * - So, when we want to pass the data through constructor, what we should do is? we need to first create the constructor for instance variables in the java POJO file.
 * 		Then goto Spring.xml file and create a bean tag and then call the <constructor-arg> tag. 
 * 			ex: <constructor-arg name="age" value = "24"/>
 * 
 * - We have two types of Dependency Injections: 1) Setter injection and 2) Constructor Injection
 * 		Depending on our bean Structure we will be using either Constructor Injection or Setter Injection. 
 * 			**If our bean(POJO Class file "Student.java") is having only "Constructor and Getter's" methods then we will be trying to call the "Constructor Dependency Injection".
 *   		**If our bean(POJO Class file "Student.java") is having only "Setter's and Getter's" methods then we willl be trying to call the "Setter Dependency Injection".
 *   					If there are no constructors means then we will make use of "Setter Dependency Injection".
 *   *****    It all depends on how the class is defined internally.   ******
 *   
 *  - We can also use both "Constructor Dependency Injection" and "Setter Dependency Injection" at the same time.
 *   
 * - Maven dependency is nothing but a jar file.  
 *   
 * 
 *  
 * 
 * */















































