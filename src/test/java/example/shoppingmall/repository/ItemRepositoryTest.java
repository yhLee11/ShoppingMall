package example.shoppingmall.repository;

import example.shoppingmall.constant.ItemSellStatus;
import example.shoppingmall.enitity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static example.shoppingmall.constant.ItemSellStatus.SELL;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @BeforeEach
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {

        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setItemNm("Test Item" + i);
            item.setPrice(10000 + i * 1000);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
            System.out.println(savedItem.toString());
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {
        this.createItemTest();
        List<Item> itemList = itemRepository.findByItemNm("Test Item");
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품명, 상품상세설명 OR 테스트")
    public void findByItemNmOrItemDetailTest() {
//        this.createItemTest();
        List<Item> byItemNmOrItemDetail = itemRepository.findByItemNmOrItemDetail("Test Item", "테스트 상품 상세 설명");
        for (Item item : byItemNmOrItemDetail) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    public void findByPriceLessThanTest() {
        List<Item> byPriceLessThan = itemRepository.findByPriceLessThan(15000);
        for (Item item : byPriceLessThan) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    public void findByPriceLessThanOrderByPriceDesc() {
        List<Item> byPriceLessThanOrderByPriceDesc = itemRepository.findByPriceLessThanOrderByPriceDesc(15000);
        for (Item item : byPriceLessThanOrderByPriceDesc) {
            System.out.println("item = " + item);
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest() {
        List<Item> byItemDetail = itemRepository.findByItemDetail("테스트 상품 상세 설명");
        for (Item item : byItemDetail) {
            System.out.println(item);
        }
    }

    @Test
    @DisplayName("nativeQuery 속성을 이용한 상품 조회 테스트")
    public void findByItemDetailByNative() {
        List<Item> byItemDetailByNative = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");
        for (Item item : byItemDetailByNative) {
            System.out.println(item);
        }
    }
}