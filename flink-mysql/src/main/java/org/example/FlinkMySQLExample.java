package org.example;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

public class FlinkMySQLExample {
    public static void main(String[] args) {
        //创建Flink执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings settings = EnvironmentSettings.newInstance().inStreamingMode().build();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env,settings);

        //创建MySQL表
        tableEnv.executeSql("CREATE TABLE student (id INT,name VARCHAR(20),age INT)"+
                "WITH (" +
                "'connector' = 'jdbc'," +
                "'driver' = 'com.mysql.cj.jdbc.Driver'," +
                "'url' = 'jdbc:mysql://192.168.195.132:3306/mysql'," +
                "'table-name' = 'student'," +
                "'username' = 'root'," +
                "'password' = '123456'" +
                ")");

        //查询
        Table resultTable = tableEnv.sqlQuery("SELECT * FROM student");

        //toRetractStream()将查询结果将转换为DataStream<Row>类型，并打印结果
        tableEnv.toRetractStream(resultTable, Row.class).print();
        try {
            env.execute("Flink MySQL Example");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}