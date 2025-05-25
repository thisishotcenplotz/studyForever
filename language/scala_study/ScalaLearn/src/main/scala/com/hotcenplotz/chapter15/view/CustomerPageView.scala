package com.hotcenplotz.chapter15.view

import com.hotcenplotz.chapter15.model.Customer
import com.hotcenplotz.chapter15.service.CustomerService

import scala.io.StdIn

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 14:39 
 * @description:
 * */
class CustomerPageView {
    
    private var loop: Boolean = true
    private val customerService: CustomerService = CustomerService.getInstance()
    
    
    def mainMenu(): Unit = {
        val mainView: String =
            s"""
               |++++++++++++++++++ 客户信息管理系统 ++++++++++++++++++
               |                 1. 添 加 客 户
               |                 2. 修 改 客 户
               |                 3. 删 除 客 户
               |                 4. 客 户 列 表
               |                 5. 退      出
               |""".stripMargin
        
        do {
            println(mainView)
            print("请选择(1-5):")
            
            val key: Char = StdIn.readChar()
            
            key match {
                case '1' => addCustomer()
                case '2' => alterCustomer()
                case '3' => deleteCustomer()
                case '4' => this.cusList()
                case '5' => this.loop = false
            }
            
        } while (loop)
    }
    
    private def cusList(): Unit = {
        println("-------------------------客户列表-------------------------")
        println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱")
        this.customerService.list().map(_.displayString).foreach(println)
        println("---------------------------------------------------------")
    }
    
    private def addCustomer(): Unit = {
        println("-------------------------添加客户-------------------------")
        print("姓名：")
        val name: String = StdIn.readLine()
        print("性别:")
        val gender: Char = StdIn.readChar()
        print("年龄:")
        val age: Short = StdIn.readShort()
        print("电话:")
        val tel: String = StdIn.readLine()
        print("邮箱:")
        val email: String = StdIn.readLine()
        
        val newCus: Customer = Customer(id = -1, name = name, gender = gender, age = age, tel = tel, email = email)
        try {
            customerService.add(newCus)
            println("添加成功")
            println(newCus)
        } catch {
            case e: Exception => {
                println(e.getMessage)
            }
        }
    }
    
    def deleteCustomer(): Unit = {
        print("请输入用户ID:")
        val id: Int = StdIn.readInt()
        customerService.delete(id)
    }
    
    def alterCustomer(): Unit = {
        print("请输入要修改的用户ID:")
        val cusId: Int = StdIn.readInt()
        
        val oldCus: Customer = customerService.get(cusId)
        
        if (oldCus.isInstanceOf[Customer]) {
            print("请输入新的姓名：")
            val name: String = StdIn.readLine()
            print("请输入新的性别:")
            val gender: Char = StdIn.readChar()
            print("请输入新的年龄:")
            val age: Short = StdIn.readShort()
            print("请输入新的电话:")
            val tel: String = StdIn.readLine()
            print("请输入新的邮箱:")
            val email: String = StdIn.readLine()
            
            val newCus: Customer = Customer(id = -1, name = name, gender = gender, age = age, tel = tel, email = email)
            
            // update = delete + insert
            customerService.delete(cusId)
            customerService.add(newCus)
            
        } else throw new RuntimeException("Oops... something wrong")
    }
}
