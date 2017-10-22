package udemy.saurabh.springguru201restfulfruits.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.model.Customer;

@Mapper
public interface ICustomerMapper {

	ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

	CustomerDTO customerToCustomerDTO(Customer customer);

	Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
