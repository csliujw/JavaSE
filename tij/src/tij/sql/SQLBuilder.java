package tij.sql;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;


@SuppressWarnings("all")
public class SQLBuilder {

    /**
     * 获取要生成的表的名称
     *
     * @param className 类全名
     * @return 表名
     * @throws ClassNotFoundException
     */
    public String getTableName(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        DBTable annotation = clazz.getAnnotation(DBTable.class);
        String tableName = annotation.name();
        if (tableName.length() < 1) {
            tableName = clazz.getName().toUpperCase();
        }
        return tableName.toUpperCase();
    }


    /**
     * @param clazz 字节码对象
     * @return 由列信息组成的ArrayList<String>字符串</>
     */
    public ArrayList<String> getColumns(Class clazz) {
        ArrayList<String> columnDefs = new ArrayList<String>();
        for (Field field : clazz.getDeclaredFields()) {
            // because have different annotations, so we need get all type annotations.
            Annotation[] annotations = field.getAnnotations();
            // because every filed only one annotations
            Annotation ant = annotations[0];
            // column name
            String columnName = "";
            if (ant instanceof SQLString) {
                SQLString tmp = (SQLString) ant;
                columnName = tmp.name();
                if (columnName.length() < 1) {
                    columnName = field.getName();
                }
                int length = tmp.value();
                String constraints = getConstraints(tmp.constraints());
                StringBuilder append = new StringBuilder().append("\t").append(columnName)
                        .append(" VARCHAR(")
                        .append(length)
                        .append(")")
                        .append(constraints);
                columnDefs.add(append.toString());
            }

            if (ant instanceof SQLInteger) {
                SQLInteger tmp = (SQLInteger) ant;
                columnName = tmp.name();
                if (columnName.length() < 1) {
                    columnName = field.getName();
                }
                String constraints = getConstraints(tmp.constraints());
                StringBuilder append = new StringBuilder().append("\t").append(columnName)
                        .append(" INT ")
                        .append(constraints);
                columnDefs.add(append.toString());
            }
        }
        return columnDefs;
    }


    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }

    public String getCreateSQL(String className) throws ClassNotFoundException {
        String tableName = getTableName(className);
        Class clazz = Class.forName(className);
        ArrayList<String> columns = getColumns(clazz);
        StringBuilder createSQL = new StringBuilder("CREATE TABLE (\n");
        for (String column : columns) {
            createSQL.append(column).append(",\n");
        }
        // 去除一个逗号和一个换行符
        createSQL.deleteCharAt(createSQL.length() - 1);
        createSQL.deleteCharAt(createSQL.length() - 1);
        createSQL.append("\n);");
        return createSQL.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        SQLBuilder sqlBuilder = new SQLBuilder();
        SQLCase sqlCase = new SQLCase();
        String createSQL = sqlBuilder.getCreateSQL("org.example.tij.sql.SQLCase");
        System.out.println(sqlBuilder.getCreateSQL("org.example.tij.sql.SQLCase"));
    }
}
