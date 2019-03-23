package WireCodingTest.CodingTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainContorller {

    @GetMapping("/index")
    public String home() {
        return "index";
    }

}
