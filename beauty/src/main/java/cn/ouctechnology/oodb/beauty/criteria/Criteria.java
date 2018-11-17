package cn.ouctechnology.oodb.beauty.criteria;

import cn.ouctechnology.oodb.beauty.session.Session;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:41
 * @description: TODO
 **/
public class Criteria {

    private String tableName;

    private String tableAlias;

    private Session session;


    private List<Criterion> criterionEntries = new ArrayList<>();
    private List<Order> orderEntries = new ArrayList<>();
    private List<JoinCondition> joinEntries = new ArrayList<>();
    private Integer maxResults;
    private Integer firstResult;
    private boolean distinct;
    private Projection projection;


    public Criteria(Class clz, Session session) {
        this.tableName = StringUtils.uncapitalize(clz.getSimpleName());
        this.tableAlias = tableName;
        this.session = session;
    }

    public Criteria(Class clz, String tableAlias, Session session) {
        this.tableName = StringUtils.uncapitalize(clz.getSimpleName());
        this.tableAlias = tableAlias;
        this.session = session;
    }


    public Criteria add(Criterion expression) {
        if (expression == null) return this;
        criterionEntries.add(expression);
        return this;
    }

    public Criteria setDistinct() {
        this.distinct = true;
        return this;
    }

    public Criteria addOrder(Order ordering) {
        if (ordering == null) return this;
        orderEntries.add(ordering);
        return this;
    }

    public Criteria addJoinCondition(JoinCondition joinCondition) {
        if (joinCondition == null) return this;
        joinEntries.add(joinCondition);
        return this;
    }


    public Criteria setProjection(Projection projection) {
        if (projection == null) return this;
        this.projection = projection;
        return this;
    }


    public Criteria setMaxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }


    public Criteria setFirstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    public List list(Class clz) {
        return session.createQuery(getOql()).list(clz);
    }

    //todo 如何遍历
    public List list() {
        return session.createQuery(getOql()).list();
    }

    public Object uniqueResult() {
        return list().get(0);
    }

    public Object uniqueResult(Class clz) {
        return list(clz).get(0);
    }

    public String getOql() {
        StringBuilder sb = new StringBuilder();
        sb.append("select ");
        if (distinct) sb.append("distinct ");
        sb.append(getSelectOql()).append(" ");
        sb.append(getFromOql()).append(" ");
        sb.append(getWhereOql()).append(" ");
        sb.append(getGroupByOql()).append(" ");
        sb.append(getOrderOql()).append(" ");
        sb.append(getLimitOql()).append(" ");
        return sb.toString();
    }

    private String getSelectOql() {
        if (projection == null || projection instanceof GroupByProjection) {
            StringBuilder sb = new StringBuilder();
            sb.append(tableAlias);
            for (JoinCondition joinEntry : joinEntries) {
                sb.append(",").append(((SimpleJoinCondition) joinEntry).getAlias());
            }
            return sb.toString();
        }
        return projection.toOqlString(tableAlias);
    }

    private String getFromOql() {
        StringBuilder sb = new StringBuilder("from " + tableName + " " + tableAlias);
        for (JoinCondition joinEntry : joinEntries) {
            sb.append(joinEntry.toOqlString(tableName));
        }
        return sb.toString();
    }

    private String getGroupByOql() {
        if (projection instanceof ProjectionList) {
            String group = ((ProjectionList) projection).getGroup();
            if (group != null) return "group by " + group;
        }
        if (projection instanceof GroupByProjection) {
            return "group by " + projection.toOqlString(tableAlias);
        }
        return "";
    }

    private String getLimitOql() {
        if (maxResults == null) return "";
        if (firstResult == null) firstResult = 0;
        return "limit " + firstResult + "," + maxResults;
    }

    private String getOrderOql() {
        if (orderEntries.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(" order by ");
        for (Order orderEntry : orderEntries) {
            sb.append(orderEntry.toOqlString(tableAlias));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    private String getWhereOql() {
        if (criterionEntries.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(" where ");
        for (Criterion criterionEntry : criterionEntries) {
            sb.append(criterionEntry.toOqlString(tableAlias));
            sb.append(" and ");
        }
        sb.delete(sb.length() - 5, sb.length());
        return sb.toString();
    }

}
