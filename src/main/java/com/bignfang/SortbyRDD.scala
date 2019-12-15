package com.bignfang

import org.apache.spark.{SparkConf, SparkContext}

object SortbyRDD {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SortByRDD")
        val sparkContext = new SparkContext(sparkConf)
        sparkContext.makeRDD(List(1,2,3,4,5,6),4)
            .sortBy(x=>x,true,1)
            .saveAsTextFile("output")
    }
}
