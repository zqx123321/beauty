package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;

import java.io.IOException;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-10 11:57
 * @description: TODO
 **/
public class SyncExplain {

    public synchronized static String sync() {
        try {
            Catalog.storeCatalog();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Buffer.close();
        return "sync data successfully";
    }
}
