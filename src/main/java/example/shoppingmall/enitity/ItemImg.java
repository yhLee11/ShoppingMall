package example.shoppingmall.enitity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item_img")
@Getter
@Setter
public class ItemImg {
    private Long id;
}
