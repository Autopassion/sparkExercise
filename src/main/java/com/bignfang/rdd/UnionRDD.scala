package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object UnionRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("UnionRDD")
        val sparkContext = new  SparkContext(sparkConf)
        val RDD1: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5))
        val RDD2: RDD[Int] = sparkContext.makeRDD(List(6,7,8,9,10))
        val unionRDD: RDD[Int] = RDD1.union(RDD2)
        unionRDD.collect().foreach(println)
    }
}
