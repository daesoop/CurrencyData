package CurrencyCalculator.controller;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @PostMapping("/makeFile")
    public void test(@RequestBody String element) {
        Map<String, String> map = new HashMap<>();
        System.out.println("success !!!!");
        System.out.println(element);

        List<String> list = new ArrayList<>();
        List<String> checkList = new ArrayList<>();
        list.add("header");
        list.add("leftcolumn");
        list.add("rightcolumn");
        list.add("content");
        list.add("footer");

        String[] array = element.split("<div id=");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].substring(2);
            System.out.println("가자~ : " + array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (array[i].startsWith(list.get(j))) {
                    checkList.add(array[i]);
                    System.out.println(list.get(j));
                };
            };
        }



        System.out.println(checkList.size());
    }

}
