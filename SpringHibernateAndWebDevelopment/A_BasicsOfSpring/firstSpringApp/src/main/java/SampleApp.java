import com.saurabh.service.CustomerService;
import com.saurabh.service.CustomerServiceImpl;

public class SampleApp {

	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();

		System.out.println(service.findAll().get(0).getFirstName());


	}

}
