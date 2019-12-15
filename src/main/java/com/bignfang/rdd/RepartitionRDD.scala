package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RepartitionRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("RepartitionRDD")
        val sparkContext = new SparkContext(sparkConf)
        val intRDD: RDD[Int] = sparkContext.makeRDD(List(1,2,3,4,5,6,7,8),4)
        intRDD.repartition(2)
            .saveAsTextFile("output")
    }
}
