package com.bignfang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object GroupByRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("GroupByRDD")
        val sparkContext = new SparkContext(sparkConf)
        val intRDD: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5))
        val groupByRDD: RDD[(Int, Iterable[Int])] = intRDD.groupBy(i => i%2)
        groupByRDD.collect().foreach(println)
    }
}
