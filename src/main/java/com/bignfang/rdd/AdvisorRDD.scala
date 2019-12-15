package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object AdvisorRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("AdvisorRDD")
        val sparkContext = new SparkContext(sparkConf)
        val stringRDD: RDD[String] = sparkContext.textFile("in/ad.tx￿t")
        val mapRDD: RDD[((String, String), Int)] = stringRDD.map(line => {
            val fields: Array[String] = line.split(" ")
            ((fields(1), fields(2)), 1)
        })
        val adRDD: RDD[(String, (String, Int))] = mapRDD.reduceByKey(_ + _).map(ads => {
            (ads._1._1, (ads._1._2, ads._2))
        })

        val adListRDD: RDD[(String, Iterable[(String, Int)])] = adRDD.groupByKey()

        val resultRDD: RDD[(String, List[(String, Int)])] = adListRDD.mapValues(data => {
            data.toList.sortWith((x, y) => x._2 > y._2).take(3)
        })
        resultRDD.collect.foreach(println)
    }
}
