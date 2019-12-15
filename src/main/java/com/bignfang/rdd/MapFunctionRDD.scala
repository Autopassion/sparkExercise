package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object MapFunctionRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("MapFunctionRDD")
        val sparkContext = new SparkContext(sparkConf)
        val intRDD: RDD[Int] = sparkContext.parallelize(List(1,2,3,4,5))
        val mapRDD: RDD[Int] = intRDD.map(_*2)
        mapRDD.collect.foreach(println)
    }
}
