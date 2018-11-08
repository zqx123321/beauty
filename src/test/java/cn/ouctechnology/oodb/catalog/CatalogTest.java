package cn.ouctechnology.oodb.catalog;

import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.catalog.attribute.CharAttribute;
import cn.ouctechnology.oodb.catalog.attribute.IntAttribute;
import cn.ouctechnology.oodb.catalog.attribute.ObjectAttribute;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 20:42
 * @description: TODO
 **/
public class CatalogTest {

    @Test
    public void initialCatalog() throws IOException {
        Catalog.initialCatalog();
        System.out.println(Catalog.showCatalog());
    }

    @Test
    public void storeCatalog() {
    }

    @Test
    public void showCatalog() {
    }

    @Test
    public void testCreateTable() throws IOException {
        Catalog.initialCatalog();
        Attribute objectAttribute = new ObjectAttribute(
                "dept",
                30,
                Arrays.asList(new IntAttribute("id", 4), new CharAttribute("deptNme", 30)));
        Table table = new Table(
                "teacher",
                Arrays.asList("id"),
                Arrays.asList(new IntAttribute("id", 4), new CharAttribute("name", 20), objectAttribute),
                new ArrayList<Index>(), 0
        );

        Catalog.createTable(table);
        Catalog.showCatalog();
        Catalog.storeCatalog();
    }

    @Test
    public void testCreateTablePerson() throws IOException {
        Catalog.initialCatalog();
        Table table = new Table(
                "person",
                Arrays.asList("id"),
                Arrays.asList(new IntAttribute("id", 4), new CharAttribute("name", 20)),
                new ArrayList<Index>(), 0
        );

        Catalog.createTable(table);
        Catalog.showCatalog();
        Catalog.storeCatalog();
    }
}