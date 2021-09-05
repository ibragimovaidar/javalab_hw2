import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SignUpService signUpService = applicationContext.getBean("signUpService", SignUpService.class);
		signUpService.signUp("ibragimovaidarp@gmail.com", "123");
		signUpService.signUp("safjkldsjfsd", "qwerty008");
		signUpService.signUp("ibragimovaidarp2@gmail.com", "qwerty008");
		signUpService.signUp("safjkldsjfsd", "123");


	}
}
