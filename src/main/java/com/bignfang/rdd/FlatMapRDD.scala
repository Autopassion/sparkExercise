package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object FlatMapRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("FlatMapRDD")
        val sparkContext = new SparkContext(sparkConf)
        val arrayRDD: RDD[Array[Int]] = sparkContext.makeRDD(List(Array(1,2),Array(2,3)))
        arrayRDD.flatMap(datas => datas)
            .collect()
            .foreach(println)
    }
}
