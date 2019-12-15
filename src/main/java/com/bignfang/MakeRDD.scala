package com.bignfang

import org.apache.spark.{SparkConf, SparkContext}

object MakeRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[3]").setAppName("MakeRDD")
        val sparkContext = new SparkContext(sparkConf)
        val listRDD = sparkContext.makeRDD(List(1,2,3,4))
        listRDD.collect().foreach(println)
    }
}
