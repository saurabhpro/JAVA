package udemy.saurabh.springguru201restfulfruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.saurabh.springguru201restfulfruits.model.Vendor;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor, Long> {
}
