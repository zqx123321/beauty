package cn.ouctechnology.oodb.buffer;

import java.util.Objects;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 17:17
 * @description: 区块索引，由文件和区块在文件中的编号决定
 **/
public class BlockKey {
    public String filename;//文件名
    public int blockOffset;//在文件中的偏移量

    public BlockKey() {
    }

    public BlockKey(String filename, int blockOffset) {
        this.filename = filename;
        this.blockOffset = blockOffset;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockKey blockKey = (BlockKey) o;
        return blockOffset == blockKey.blockOffset &&
                Objects.equals(filename, blockKey.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, blockOffset);
    }
}
