package cn.ouctechnology.oodb;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 11:52
 * @description: TODO
 **/
public class BaseTest {
    @Before
    public void init() throws IOException {
        Catalog.initialCatalog();
        Buffer.init();
    }

    @After
    public void close() throws IOException {
        Catalog.storeCatalog();
        Buffer.close();

    }
}
