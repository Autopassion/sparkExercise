package com.bignfang

import java.sql.{Connection, DriverManager}

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.{SparkConf, SparkContext}

object MysqlRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("MysqlRDD")
        val sparkContext = new SparkContext(sparkConf)
        val driver = "com.jdbc.mysql.Driver"
        val url = "jdbc:mysql://10.24.68.214:3306/yabuli_auth"
        val user = "root"
        val password = "123456"

        val jdbcRDD = new JdbcRDD(sparkContext, () => {
            Class.forName(driver)
            val connection: Connection = DriverManager.getConnection(url, user, password)
            connection
        },
            "select * from person where id >= ? and id <= ?",
            1,
            10,
            1,
            result => (result.getInt(1),result.getString(2),result.getInt(3))
        )
        val collectRDD: Array[(Int, String, Int)] = jdbcRDD.collect
        val list = List(collectRDD)
        println(list)

    }
}
