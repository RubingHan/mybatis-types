package com.github.javaplugs.mybatis;

import org.postgresql.ds.PGSimpleDataSource;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.Statement;

public class PostgresqlSuite {

    private static final String PG_URL = "jdbc:postgresql://javaplugs/javaplugs?user=javaplugs&password=javaplugs";

    private static final String PG_SQL = "/postgresql.sql";

    @BeforeSuite
    public void init() {
        INIT();
    }

    public static synchronized void INIT() {

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUrl(PG_URL);

        try (final Connection cnx = ds.getConnection(); final Statement st = cnx.createStatement()) {
            st.execute(TestSuite.getResourceAsString(PG_SQL));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        TestSuite.setupSessionFactoryBuilder(ds);
    }
}
