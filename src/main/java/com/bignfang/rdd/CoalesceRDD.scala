package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object CoalesceRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setAppName("Coalesce").setMaster("local[*]")
        val sparkContext = new SparkContext(sparkConf)
        val colesceRDD: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5,6,7,8,9,10)).coalesce(1)
        colesceRDD.collect().foreach(println)
    }
}
