package com.bignfang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ParalizeRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("ParalizeRDD")
        val sparkContext: SparkContext = new SparkContext(sparkConf)
        val parallelizeRDD: RDD[Int] = sparkContext.parallelize(List(1, 2, 3, 4))
        parallelizeRDD.collect().foreach(println)
    }
}
