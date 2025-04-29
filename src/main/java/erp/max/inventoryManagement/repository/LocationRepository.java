package erp.max.inventoryManagement.repository;

import erp.max.inventoryManagement.model.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Repository
public interface LocationRepository extends JpaRepository<Location,String> {
    Optional<Location> findByLocationCode(String code);
    Page<Location> findAll(Pageable pageable);
}
