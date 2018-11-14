package cn.ouctechnology.oodb.util;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: parser
 * @author: ZQX
 * @create: 2018-10-15 22:43
 * @description: TODO
 **/
@SuppressWarnings("unchecked")
public class ParseTreeUtil {

    public static <T extends ParseTree> T getChild(ParseTree parent, Class childType) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ParseTree child = parent.getChild(i);
            if (childType.isInstance(child)) {
                return (T) child;
            }
        }
        return null;
    }

    public static <T extends ParseTree> List<T> getChildren(ParseTree parent, Class childType) {
        int childCount = parent.getChildCount();
        List<T> children = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            ParseTree child = parent.getChild(i);
            if (childType.isInstance(child)) {
                children.add((T) child);
            }
        }
        return children;
    }
}
