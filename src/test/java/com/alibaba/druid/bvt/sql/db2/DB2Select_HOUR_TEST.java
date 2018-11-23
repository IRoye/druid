package com.alibaba.druid.bvt.sql.db2;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.db2.parser.DB2StatementParser;

import java.util.List;

public class DB2Select_HOUR_TEST {

    public static void main(String[] args) {
        String sql = "SELECT CHECKTIME AS CHECKTIME, DBID FROM CUST1.MYSQL_INFORMATION_TAB WHERE CHECKTIME BETWEEN (TIMESTAMP('2018-08-10 00:00:00') -24 HOUR) and (TIMESTAMP('2018-08-10 00:00:00') + 24 HOUR)";

        DB2StatementParser parser = new DB2StatementParser(sql);
        List<SQLStatement> statementList = parser.parseStatementList();
        SQLSelectStatement stmt = (SQLSelectStatement) statementList.get(0);
    }
}
