package com.hotcenplotz.chapter15.service

import com.hotcenplotz.chapter15.model.Customer

import scala.collection.mutable.ListBuffer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 15:02 
 * @description:
 * */
class CustomerService {
    private lazy val customers: ListBuffer[Customer] = ListBuffer[Customer]()
    
    def list(): ListBuffer[Customer] = this.customers
    
    def add(cus: Customer): Boolean = {
        try {
            val id: Int = this.customers.size + 1
            cus.id = id
            customers.addOne(cus)
            true
        } catch {
            case e: Exception => {
                println(e.getMessage)
                false
            }
        }
    }
    
    def delete(id:Int):Unit = {
        customers.remove(id -1)
        this.dataRefresh()
    }
    
    def get(id:Int):Customer = {
        if(id <= customers.size) customers(id -1)
        else throw new RuntimeException(s"Can't find id:$id")
    }
    
    private def dataRefresh():Unit = {
        val total: Int = customers.size
        val temp: IndexedSeq[(Int, Customer)] = (1 to total).zip(customers)
        val newData: IndexedSeq[Customer] = temp.map { row =>
            val newId: Int = row._1
            val cus: Customer = row._2
            cus.id = newId
            cus
        }
        customers.clear()
        newData.foreach(c => customers.addOne(c))
    }
    
    
}

object CustomerService {
    private var instance: CustomerService = null
    
    def getInstance(): CustomerService = {
        if (instance == null) {
            this.instance = new CustomerService
        }
        instance
    }
}
