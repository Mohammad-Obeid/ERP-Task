package erp.max.inventoryManagement.repository;

import erp.max.inventoryManagement.model.ProductMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductMovementRepository extends JpaRepository<ProductMovement, String> {
    Optional<List<ProductMovement>> findByProductId(String id);
}
