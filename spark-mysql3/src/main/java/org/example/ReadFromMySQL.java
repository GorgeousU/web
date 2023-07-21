package org.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

public class ReadFromMySQL {
    public static void main(String[] args){
        //创建SparkSession对象
        SparkSession spark = SparkSession.builder()
                .appName("Read from MySQL")
                .config("spark.master","spark://192.168.195.132:7077")
                .getOrCreate();
        //读取MySQL数据
        String url = "jdbc:mysql://192.168.195.132:3306/mysql";
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("driver","com.mysql.cj.jdbc.Driver");
        connectionProperties.setProperty("user","root");
        connectionProperties.setProperty("password","123456");
        Dataset<Row> dataset = spark.read()
                .jdbc(url,"stu",connectionProperties);
        //将DataFrame转换为Spark SQL中的临时表，以便可以使用SQL对其操作
        dataset.createOrReplaceTempView("stu");
        //SQL语言
        //Dataset<Row> result1 = spark.sql("INSERT INTO stu VALUES ('s1005','yue',21,'c003',4800,1100)");
        //System.out.println("数据添加成功");
        Dataset<Row> result2 = spark.sql("SELECT * FROM stu");
        result2.show();
        spark.close();
    }
}