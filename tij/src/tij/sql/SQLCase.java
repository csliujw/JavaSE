package tij.sql;

/**
 * 数据库表实体类。
 */
@DBTable(name = "SQLCase")
public class SQLCase {

    @SQLString(30)
    String firstName;

    @SQLString(60)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 120, constraints = @Constraints(primaryKey = true))
    String handle;
}