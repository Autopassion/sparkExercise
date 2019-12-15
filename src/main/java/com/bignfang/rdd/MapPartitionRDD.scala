package com.bignfang.rdd

import org.apache.spark.{SparkConf, SparkContext}

object MapPartitionRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("MapPartitionRDD")
        val sparkContext = new SparkContext(sparkConf)
        sparkContext.makeRDD(1 to 10)
            .mapPartitions(datas => datas.map(_*10))
            .collect()
            .foreach(println)
    }
}
