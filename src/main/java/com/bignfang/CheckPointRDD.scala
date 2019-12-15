package com.bignfang

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object CheckPointRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setAppName("CheckPointRDD").setMaster("local[*]")
        val sparkContext = new SparkContext(sparkConf)
        sparkContext.setCheckpointDir("cp")
        val intRDD: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5,6))
        val mapRDD: RDD[(Int, Int)] = intRDD.map((_,1))
        mapRDD.checkpoint()
        val resultRDD: RDD[(Int, Int)] = mapRDD.reduceByKey(_+_)
        resultRDD.collect().foreach(println)
    }
}
