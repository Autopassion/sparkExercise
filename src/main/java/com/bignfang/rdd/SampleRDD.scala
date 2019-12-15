package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SampleRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("SampleRDD")
        val sparkContext = new SparkContext(sparkConf)
        val intRDD: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5,6,7,8,9,10))
        val sampleRDD: RDD[Int] = intRDD.sample(false,0.4,1)
        sampleRDD.collect().foreach(println)
    }
}
