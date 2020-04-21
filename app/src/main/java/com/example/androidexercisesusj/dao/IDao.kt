package com.example.androidexercisesusj.dao

interface IDao<T> {
    fun insert(element: T): T
    fun delete(element: T): Int
    fun findAll(): List<T>
    fun findOne(id: String): T?
    fun update(element: T): Int
}