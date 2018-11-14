package cn.ouctechnology.oodb.beautiful.criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:44
 * @description: TODO
 **/
public class Junction implements Criterion {
    private final Nature nature;
    private final List<Criterion> conditions = new ArrayList<Criterion>();

    protected Junction(Nature nature) {
        this.nature = nature;
    }

    Junction(Nature nature, Criterion... criterion) {
        this(nature);
        Collections.addAll(conditions, criterion);
    }

    public Junction add(Criterion criterion) {
        conditions.add(criterion);
        return this;
    }

    public Nature getNature() {
        return nature;
    }


    public Iterable<Criterion> conditions() {
        return conditions;
    }


    @Override
    public String toOqlString(String tableName) {
        if (conditions.size() == 0) {
            return "1=1";
        }

        final StringBuilder buffer = new StringBuilder().append('(');
        final Iterator itr = conditions.iterator();
        while (itr.hasNext()) {
            buffer.append(((Criterion) itr.next()).toOqlString(tableName));
            if (itr.hasNext()) {
                buffer.append(' ')
                        .append(nature.getOperator())
                        .append(' ');
            }
        }

        return buffer.append(')').toString();
    }


    /**
     * The type of junction
     */
    public enum Nature {
        /**
         * An AND
         */
        AND,
        /**
         * An OR
         */
        OR;

        /**
         * The corresponding SQL operator
         *
         * @return SQL operator
         */
        public String getOperator() {
            return name().toLowerCase();
        }
    }
}
