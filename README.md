Spring Core
-----------------------------------------------

    Pre-Requisite Skills
        JDK 8
        Java Design Patterns
        Multi Layer Archetecture

    Lab Setup
        JDK 8
        Eclipse/STS latest IDE

    Spring Framework

        is a wholesome development platform for Java Enterprise Applications.

        + Very light weight due to its modularity

            Spring Core             act as a basic layer to start for all other modules
                                    it offers Dependency Injection (DI) through an idea 
                                    IoC (Inversion of control)
            Spring Context          ApplicationContext and auto-wiring
            Speing AOP              Aspect Oriented Programming
            Spring Web              Web MVC and REST api
            Spring Security         Authorization and Authentication
            Spring Test             Testing for spring based applications and layers
            Spring Batch            Batch Processing 
            Spring ORM              Object Relational Mapping 
            Spring Boot             RAD - Rapid Application Development through auto-configuaration
            Spring Data             Offers dynamic auto implementation of repositories
            Spring Cloud            offers tools needed for microservices
            ....etc

        + Interoparability

    Dependency?

        if one software components needs to call another software component to complete an operation,
        then it si said the first component is dependent on the second. 

        Service depends on a DAO/Repo

        interface EmployeeDAO {

        }

        class EmployeeDAOJdbcImpl implements EmployeeDAO {
            //overring the methods from EmployeeDAO interface using JDBC api
        }

        class EmployeeDAOJpaImpl implements EmployeeDAO {
            //overring the methods from EmployeeDAO interface using Jpa-Hibernate api
        }

        interface EmployeeService{

        }

        class EmployeeServiceImpl implements EmployeeService{
            
            private EmployeeDAO empDao;

            public EmployeeServiceImpl(){
                //this.empDao = new EmployeeDAOJdbcImpl();
                this.empDao = new EmployeeDAOJpaImpl();
            }
            .....
        }
    
    Dependency Injection

        the dependency is supllied externally.

        class EmployeeServiceImpl implements EmployeeService{
            
            private EmployeeDAO empDao;

            public EmployeeServiceImpl(EmployeeDAO empDao){
               this.empDao = empDao;
            }
            .....
        }

        EmployeeService es1 = new EmployeeServiceImpl(new EmployeeDAOJdbcImpl());
        EmployeeService es2 = new EmployeeServiceImpl(new EmployeeDAOJpaImpl());

    Inversion Of Control

        is a way of acheving DI.

        we will have a pre-configured helper that can pass the dependency into the place where they are needed.

    Spring Core and Context

        Offer IoC and DI.

        BeanFactory         Spring Core
        ApplicationContext  Spring Context
                both of these are called bean context or bean managers ----------> 'helper'    

                If there exists soem software that can create, manage, supply and kill object of a class
                such software is called beanContext or beanManager or Container.

                and the objects that are managed by a 'Container / Context' is called a 'bean'.

                and the class whose objects are being managed is called a 'component'.


        ApplicationContext is more enchanced than BeanFactory as ApplicationContext supports 'auto wiring' which
        is not supported by BeanFactory.

        Bean Configuaration - is informing the container about how many components we have and which component is
        dependent on which other component so that the container can mange the beans accordingly.


        Bean Configuaration can be done via
            1. XML
            2. Annotations
            3. Java Based

        XML Bean Configuaration

                    bean
                        id              identity of the bean
                        class           the class name to which the bean has to be created
                        scope           singletion | prototype | request | session | global-session
                        init-method     takes the name of a method in the component class and exeuctes it each time a bean is created
                        destroy-method  takes the name of a method in the component class and exeuctes it each time a bean is killed
                        autowiring      none | byName | byType 
                        factory-method  takes the name of the factory method to create a bean

                            property
                                name        the name of the field
                                value       the value of the field if the field is primitive or string
                                ref         the ref of another bean that acts the value of the field

                            constructor-arg
                                index       the zero-based position of the arguemnt in the constructor
                                value       the value of the ARG if the ARG is primitive or string
                                ref         the ref of another bean that acts the value of the ARG

                beans.xml

                    <beans>
                        <bean id="ed1" class="com.cts.hrm.dao.EmployeeDAOJdbcImpl" />
                        <bean id="ed2" class="com.cts.hrm.dao.EmployeeDAOJpaImpl" />

                        <bean id="es1" class="com.cts.hrm.dao.EmployeeServiceImpl" >
                            <property name="empDao" ref="ed1" />
                        </bean>

                        <bean id="es2" class="com.cts.hrm.dao.EmployeeServiceImpl" >
                            <constructor-arg index="0" ref="ed2" />
                        </bean>

                         
                        <bean id="dataFile" class="java.io.File" >
                            <constructor-arg index="0" value="./myfile.txt" />
                        </bean>

                    </beans>

                ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

                EmployeeService empService1 = (EmployeeService) context.getBean("es1");                
                EmployeeService empService2 = (EmployeeService) context.getBean("es1");                
                EmployeeService empService3 = (EmployeeService) context.getBean("es1");                

        Annotation Based Configuaration

            @Component("as")
            public class ArithemticService {                <bean class="ArithemticService" id="as" />
                .....
            }
            
            @Component
            public class ArithemticService {                <bean class="ArithemticService" id="arithemticService" />
                .....
            }

            @Component
                @Service
                @Repository
                ....etc.,

            @Service
            public class ArithemticService {                <bean class="ArithemticService" id="arithemticService" />
                .....
            }

            @Scope("")
            @PostConstruct
            @PreDestroy

            @Value
            @Autowired

            @Configuaration
            @ComponentScan("base-package")
            public class Myconfig {

            }

        Java Based Configuaration
        
            @Configuaration
            @ComponentScan("base-package")
            public class Myconfig {

                @Bean
                public File dataFile(){
                    return new File("./myfile.txt");
                }
            }

    Spring Boot
    -------------------------------------------------------------------------------------

        is spring module that offers auto-configuaration and there by 
        supporting Rapid Application Development.

        1. spring initilizer web tool
        2. STS
        3. Spring Boot CLI

        @SpringBootApplication = @AutoConfiguaration + @ComponentScan + @PropertySource + @Configuaraiton

        the application initiation is always guided by speacial classes implementing Runners.

        CommadLineRunner is an interface that has to be implemented by classes that
        serves as the application entry point.

    Assignment
    ------------------------------------------------------------------------------------------

        Develop a Spring Boot DI applciation as below:

            EmployeeRepo    <---> EmployeeService <-----> EmployeeCrudScreen (CommandLineRunner)
                Map<Long,Employee>      

                offer                   offer the                   needs to accept the operation 
                method to               method to                   from the user and delegate it to the underlying service
                add,remove,             add,remove,                 and the display the result coming from the service.
                retrive                 retrive employees
                employees               by delegating the calls
                                        to the underlying repo
                                        after required validation

    Spring Data Jdbc
    -----------------------------------------------------------------------------------------------------------

        is module of spring framework used to connect a database .

        JdbcTemplate
        NamedParameterJdbcTemplate
                update
                query
                queryForObject

    Spring AOP
    ---------------------------------

        Aspect Oriented Programming

            An aspect is a cross cutting concern, free of any bussiness logic but goes hand-in-hand
            with the bussiness logic.

            Logging
            Authentication and Authorization
            Transaction Management ..etc are a few aspects.

            An aspect is executing an ADVICE at a choosen POINT-CUT out of various JOIN-POINTS
            in an application.

            Join Point - is any place in your application at which an advice must inteveine.

                method calls
                expection handling ...etc are join points

            Point Cut - is an expression (method signature) through which a specific 
                join point is choosen for an advice.

            Advice  - is the piece of implementation that has to execute at the coosen point-cut.

            Aspect Types
                Around              execute an advice before invoking and after executing a join-point choosen by a point-cut
                Before              execute an advice before invoking a  join-point choosen by a point-cut
                After               execute an advice after executing a  join-point choosen by a point-cut
                After Throwing      execute an advice after a  join-point choosen by a point-cut throws a excepton
                After Returning     execute an advice after a  join-point choosen by a point-cut returns a value

        PointCut Expression
        ------------------------
        "execution(* packageName.ClassName.methodName(...))"
        
        AspectJ Annotations
        -------------------------
        @EnableAspectJAutoProxy
        @Aspect - Represents an aspect advice class.
        @Before – Run before the method execution
        @After – Run after the method returned a result
        @AfterReturning – Run after the method returned a result, intercept the returned result as well.
        @AfterThrowing – Run after the method throws an exception
        @Around – Run around the method execution, combine all three advices above.
        
        
        <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<scope>compile</scope>
		</dependency>