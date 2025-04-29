package erp.max.inventoryManagement.repository;

import erp.max.inventoryManagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductBarcode(String barcode);
    Page<Product> findAll(Pageable pageable);

}
