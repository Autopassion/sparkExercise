package com.bignfang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object IntersactionRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("IntersactionRDD")
        val sparkContext = new SparkContext(sparkConf)
        val RDD1: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5))
        val RDD2: RDD[Int] = sparkContext.makeRDD(List(2,3,4,5,7,8))
        val interSectionRDD: RDD[Int] = RDD1.intersection(RDD2)
        interSectionRDD.collect().foreach(println)
    }
}
