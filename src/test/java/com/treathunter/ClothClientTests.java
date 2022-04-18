package com.treathunter;

import com.treathunter.rest.clients.ClothClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClothClientTests {
    @Autowired
    private ClothClient clothClient;

    @Test
    public void test() {
        Assertions.assertThrows(RuntimeException.class,() -> {
            clothClient.findByBarcode(1111L);
        });
       System.out.println( );
    }
}
