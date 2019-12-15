package com.bignfang.rdd

import org.apache.spark.{SparkConf, SparkContext}

object DistinctRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("DisdinctRDD")
        val sparkContext = new SparkContext(sparkConf)
        sparkContext.makeRDD(List(1,1,2,4,5,6,7,8,9,10))
            .distinct()
            .collect()
            .foreach(println)
    }
}
