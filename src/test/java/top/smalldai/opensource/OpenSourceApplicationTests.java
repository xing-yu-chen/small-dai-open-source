package top.smalldai.opensource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.smalldai.opensource.util.generator.utils.NameStrUtil;

@SpringBootTest
class OpenSourceApplicationTests {

    @Test
    void contextLoads() {
        String name = NameStrUtil.columnNameStringDealing("Zhangsan_nameMm");
        System.out.println(name);
    }

}
