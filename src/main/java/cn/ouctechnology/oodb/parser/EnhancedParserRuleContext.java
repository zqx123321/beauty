package cn.ouctechnology.oodb.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-17 10:12
 * @description: TODO
 **/
public class EnhancedParserRuleContext extends ParserRuleContext {

    public EnhancedParserRuleContext() {
        super();
    }

    public EnhancedParserRuleContext(ParserRuleContext parent, int invokingStateNumber) {
        super(parent, invokingStateNumber);
    }

    public <T extends EnhancedParserRuleContext> T getChild(Class childType) {
        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ParseTree child = this.getChild(i);
            if (childType.isInstance(child)) {
                return (T) child;
            }
        }
        return null;
    }

    public <T extends EnhancedParserRuleContext> List<T> getChildren(Class childType) {
        int childCount = this.getChildCount();
        List<T> children = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            ParseTree child = this.getChild(i);
            if (childType.isInstance(child)) {
                children.add((T) child);
            }
        }
        return children;
    }

    public List<TerminalNode> getTerminalNodes() {
        int childCount = this.getChildCount();
        List<TerminalNode> children = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            ParseTree child = this.getChild(i);
            if (child instanceof TerminalNode) {
                children.add((TerminalNode) child);
            }
        }
        return children;
    }
}

