package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SubtractRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SubtractRDD")
        val sparkContext = new SparkContext(sparkConf)
        val RDD1: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5,6))
        val RDD2: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,7,8,9,10))
        val subtractRDD: RDD[Int] = RDD1.subtract(RDD2)
        subtractRDD.collect().foreach(println)
    }
}
