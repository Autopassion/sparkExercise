package com.bignfang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object FileRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("FileRDD")
        val sparkContext = new SparkContext(sparkConf)
        val fileRDD: RDD[String] = sparkContext.textFile("in",3)
        fileRDD.foreach(println)
        val unit: Unit = fileRDD.saveAsTextFile("output")
    }
}
