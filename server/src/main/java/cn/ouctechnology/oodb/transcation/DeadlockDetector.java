package cn.ouctechnology.oodb.transcation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.LockInfo;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-15 10:07
 * @description: 检测死锁
 **/
public class DeadlockDetector implements Runnable {

    private Logger logger = LoggerFactory.getLogger(DeadlockDetector.class);

    private ThreadMXBean threadMXBean;

    private Map<Integer, Set<Integer>> graph;

    private boolean hasCircle;

    private Map<Integer, Boolean> visited;

    private Map<Integer, Boolean> hasVisited;

    public DeadlockDetector() {
        this.threadMXBean = ManagementFactory.getThreadMXBean();
    }

    @Override
    public void run() {

        while (TransactionMap.getThreadMap().keySet().size() > 0) {
            logger.info("detect dead lock.....");
            //直接使用ThreadMXBean提供的API
            long[] threadIds = threadMXBean.findDeadlockedThreads();
            if (threadIds == null || threadIds.length == 0) {
                logger.info("no dead lock....");
                break;
            }
            logger.error("dead lock found,process.....");
            for (long threadId : threadIds) {
                Set<Thread> threads = TransactionMap.getThreadMap().keySet();
                for (Thread thread : threads) {
                    if (thread.getId() == threadId) {
                        Transaction.rollback(thread);
                    }
                }
            }
        }
//        Set<Thread> threads = TransactionMap.getThreadMap().keySet();
//        int count = threads.size();
//        Iterator<Thread> iterator = threads.iterator();
//        while (count-- > 0 && iterator.hasNext()) {
//            logger.info("detect dead lock.....");
//            buildGraph();
//            hasCircle = false;
//            for (Map.Entry<Integer, Boolean> pointVisited : hasVisited.entrySet()) {
//                Boolean value = pointVisited.getValue();
//                if (!value) {
//                    pointVisited.setValue(true);
//                    judgeCircle(pointVisited.getKey());
//                }
//                if (hasCircle) {
//                    logger.error("dead lock found,process.....");
//                    Transaction.rollback(iterator.next());
//                    break;
//                }
//            }
//            if (!hasCircle) {
//                logger.info("no dead lock....");
//                break;
//            }
//        }
    }


    /**
     * 建立有向图
     */
    private void buildGraph() {
        graph = new HashMap<>();
        Set<Integer> pointCount = new HashSet<>();
        Set<Thread> threads = TransactionMap.getThreadMap().keySet();
        //建立有向图
        List<Long> threadIds = threads.stream().map(Thread::getId).collect(Collectors.toList());
        for (Long threadId : threadIds) {
            int thread = threadId.intValue();
            pointCount.add(thread);
            //请求
            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
            LockInfo lockInfo = threadInfo.getLockInfo();
            if (lockInfo != null) {
                int request = lockInfo.getIdentityHashCode();
                Set<Integer> points = graph.computeIfAbsent(thread, HashSet::new);
                points.add(request);
                pointCount.add(request);
            }
            //占有
            LockInfo[] locks = threadInfo.getLockedSynchronizers();
            for (LockInfo lock : locks) {
                if (lock != null) {
                    int own = lock.getIdentityHashCode();
                    pointCount.add(own);
                    Set<Integer> points = graph.computeIfAbsent(own, HashSet::new);
                    points.add(thread);
                }
            }
        }
        visited = new HashMap<>();
        hasVisited = new LinkedHashMap<>();
        for (Integer point : pointCount) {
            visited.put(point, false);
            hasVisited.put(point, false);
        }
    }

    /**
     * 深度优先搜索遍历图判断是否存在环
     */
    private void judgeCircle(int point) {
        if (hasCircle) return;
        Set<Integer> points = graph.get(point);
        if (points == null) return;
        for (Integer next : points) {
            hasVisited.put(next, true);
            Boolean visit = visited.get(next);
            if (visit) {
                hasCircle = true;
                return;
            }
            visited.put(next, true);
            judgeCircle(next);
            visited.put(next, false);
        }
    }

}
