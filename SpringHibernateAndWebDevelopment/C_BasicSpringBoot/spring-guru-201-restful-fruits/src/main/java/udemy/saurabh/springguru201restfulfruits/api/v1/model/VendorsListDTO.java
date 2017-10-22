package udemy.saurabh.springguru201restfulfruits.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VendorsListDTO {

	List<VendorsDTO> vendors;
}
