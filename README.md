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
