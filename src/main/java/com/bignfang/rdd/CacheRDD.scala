package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object CacheRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("CacheRDD")
        val sparkContext = new SparkContext(sparkConf)
        val intRDD: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,4,5,6,6),4)
        val mapRDD: RDD[(Int, Int)] = intRDD.map((_,1)).cache()
        val resultRDD: RDD[(Int, Int)] = mapRDD.reduceByKey(_+_)
        println(resultRDD.toDebugString)
        resultRDD.collect().foreach(println)
    }
}
