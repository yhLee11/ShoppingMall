package example.shoppingmall;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public UserDto test() {
        UserDto userDto = new UserDto();
        userDto.setAge(25);
        userDto.setName("yeon");
        return userDto;
    }
}
