package cn.ouctechnology.oodb.buffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 17:31
 * @description: TODO
 **/
public class BufferTest {

    @Before
    public void init() {
        Buffer.init();
    }

    @After
    public void close() {
        Buffer.close();
    }


    @Test
    public void getBlock() throws IOException {
        File file = new File("teacher.data");
        if (!file.exists()) file.createNewFile();
        Block block = Buffer.getBlock("teacher.data", 0);
        System.out.println(block.readInt());
        System.out.println(block.readFloat());
        System.out.println(block.readString(2));
        System.out.println(block);
        block.writeInt(123);
        block.writeFloat(11.11f);
        block.writeString("ad", 2);
        System.out.println(block.dirty);
        System.out.println(Arrays.toString(block.data));
    }

    @Test
    public void testLRU() {
        Block block1 = Buffer.getBlock("teacher.data", 0);
        Block block2 = Buffer.getBlock("teacher.data", 1);
        block1 = Buffer.getBlock("teacher.data", 0);
        Block block3 = Buffer.getBlock("teacher.data", 2);
    }


}