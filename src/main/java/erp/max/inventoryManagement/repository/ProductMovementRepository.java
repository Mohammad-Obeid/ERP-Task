package erp.max.inventoryManagement.repository;

import erp.max.inventoryManagement.model.ProductMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMovementRepository extends JpaRepository<ProductMovement, String> {
}
