package cn.ouctechnology.oodb.beautiful.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 12:28
 * @description: TODO
 **/
public class ProjectionList implements Projection {
    private List<Projection> elements = new ArrayList<Projection>();
    private String group = null;

    /**
     * Constructs a ProjectionList
     *
     * @see Projections#projectionList()
     */
    ProjectionList() {
    }

    public String getGroup() {
        return group;
    }

    /**
     * Lol
     *
     * @return duh
     * @see Projections#projectionList()
     * @deprecated an instance factory method does not make sense
     */
    @Deprecated
    public ProjectionList create() {
        return new ProjectionList();
    }

    /**
     * Add a projection to this list of projections
     *
     * @param projection The projection to add
     * @return {@code this}, for method chaining
     */
    public ProjectionList add(Projection projection) {
        elements.add(projection);
        return this;
    }


    @Override
    public String toOqlString(String tableName) {
        StringBuilder buf = new StringBuilder();
        String separator = "";
        for (Projection projection : elements) {
            //这很牛逼，不用删除了
            if (projection instanceof GroupByProjection) {
                group = projection.toOqlString(tableName);
                continue;
            }
            buf.append(separator).append(projection.toOqlString(tableName));
            separator = ", ";
        }
        return buf.toString();
    }


    @SuppressWarnings("UnusedDeclaration")
    public Projection getProjection(int i) {
        return elements.get(i);
    }

    public int getLength() {
        return elements.size();
    }

}
