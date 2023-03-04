package org.project.artemisgate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArtemisGateApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> {
            var x = 1 + 1;
        });
    }

}
