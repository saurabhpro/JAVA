import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = KnightConfig.class)
public class MajesticKnightTest {

	@Autowired
	private Knight knight;

	@Test
	public void test(){

		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
		//Knight knight = context.getBean(MajesticKnight.class);

		System.out.println(knight.getKnightName());

		//context.registerShutdownHook();
		//context.close();
	}

}