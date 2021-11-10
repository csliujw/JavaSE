package video;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

class Array<T> extends ArrayList implements Comparable<T> {
    @Override
    public int compareTo(T o) {
        Array a = (Array) o;
        // 然后对数组排序 拿到当前集合的数据 然后比较
        Object[] objects = this.toArray();
        Object[] objects1 = a.toArray();
        // 对objectc进行排序 然后比较他们的大小
        return 0;
    }
}


public class Demo {

    /**
     * 转入转出操作都是在同一个线程中进行的，所以可以用ThreadLocal获取为当前线程绑定的连接池。
     * @throws SQLException
     */
    public void transfer() throws SQLException {
        ThreadLocal<Connection> local = new ThreadLocal<>();
        Connection connection = local.get();
        connection.setAutoCommit(false);
        try {
            out();
            in();
        } catch (Exception e) {
            // 出错就回滚
            connection.rollback();
        } finally {
            // 提交
            connection.commit();
        }
    }

    public void out() {
        // 转出
        ThreadLocal<Connection> local = new ThreadLocal<>();
        Connection connection = local.get();
        // 执行操作
    }

    public void in() {
        // 转入
        ThreadLocal<Connection> local = new ThreadLocal<>();
        Connection connection = local.get();
        // 执行操作
    }

    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();
        List<Object> objects1 = Arrays.asList();

        Array<Integer> array = new Array<>();
        array.add(11);
        array.add(11);
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(array);

        ThreadLocal<Connection> local = new ThreadLocal();
        Connection connection = local.get();


    }
}
