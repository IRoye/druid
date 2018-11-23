package com.alibaba.druid.bvt.sql.db2;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

public class DB2SelectTest_FinalTable {

    public static void main(String[] args) {
        String sql = "select * from FINAL table ( update audit.user2 set USERPASS='2' where id in (1,21) )";
        SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, "db2");
        parser.getExprParser();
        SQLStatement stmt = SQLUtils.parseStatements(sql, JdbcConstants.DB2).get(0);
        System.out.println("SQL : " + stmt.toString());
        SchemaStatVisitor visitor = SQLUtils.createSchemaStatVisitor(JdbcConstants.DB2);
        stmt.accept(visitor);
        System.out.println("Tables : " + visitor.getTables());
    }
}
