package com.bignfang.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object PartitionByFunction {
    def main(args: Array[String]): Unit = {
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("PartitionByFunction")
        val sparkContext = new SparkContext(sparkConf)
        val rdd1: RDD[(String, Int)] = sparkContext.makeRDD(List(("a",2),("b",3),("c",4), ("d",5))).repartition(3)
//        val partitionByRDD: RDD[(String, Int)] = rdd1.partitionBy(new HashPartitioner(4))
        val partitionByRDD: RDD[(String, Int)] = rdd1.partitionBy(new SelfDefinePartitioner(4))
        val unit: Unit = partitionByRDD.saveAsTextFile("output")
    }
}

class SelfDefinePartitioner(partitionNums:Int) extends Partitioner{
    override def numPartitions: Int = {
        partitionNums
    }
    override def getPartition(key: Any): Int = {
        if("a".equals(key)){
            1
        }else if("b".equals(key)){
            2
        }else if("c".equals(key)){
            3
        }else{
            0
        }
    }
}