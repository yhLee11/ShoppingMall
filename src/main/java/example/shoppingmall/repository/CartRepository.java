package example.shoppingmall.repository;

import example.shoppingmall.enitity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
