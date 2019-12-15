package com.bignfang.sparkSql

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object SparkDataFrame {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkDateFrame")
        val sparkSession: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
        val userDataFrame: DataFrame = sparkSession.read.json("in/user.json")
        userDataFrame.show()
    }
}
