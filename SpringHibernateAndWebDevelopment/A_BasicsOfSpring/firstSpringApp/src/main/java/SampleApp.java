import com.saurabhk15.service.CustomerService;
import com.saurabhk15.service.CustomerServiceImpl;

public class SampleApp {

	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();

		System.out.println(service.findAll().get(0).getFirstName());


	}

}
