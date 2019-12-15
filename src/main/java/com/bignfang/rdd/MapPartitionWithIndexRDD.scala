package com.bignfang.rdd

import org.apache.spark.{SparkConf, SparkContext}

object MapPartitionWithIndexRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[3]").setAppName("MapPartitionWithIndexRDD")
        val sparkContext = new SparkContext(sparkConf)
        sparkContext.makeRDD(List(1,2,3,4,5,6,7,8),3)
            .mapPartitionsWithIndex {
                case (num,datas) => datas.map((_,"分区号："+num))
            }
            .collect()
            .foreach(println)
    }
}
