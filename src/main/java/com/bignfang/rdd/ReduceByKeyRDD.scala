package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ReduceByKeyRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("ReduceByKeyRDD")
        val sparkContext = new SparkContext(sparkConf)
        val stringRDD: RDD[String] = sparkContext.makeRDD(List("tom","tom","sorry","spark","demo","demo","spark","spark"))
        val mapRDD: RDD[(String, Int)] = stringRDD.map((_,1))
        val reduceByKeyRDD: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)
        val sortByKeyRDD: RDD[(String, Int)] = reduceByKeyRDD.sortBy(_._2,false,3)
        sortByKeyRDD.collect().foreach(println)
    }
}
