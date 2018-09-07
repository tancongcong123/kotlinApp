package com.jx.myktapplication.util

enum class Color(i: Int) {

    RED(0xFF0000){
        override fun print() {
            println("this is a enum const $name  fun print")
        }
    },BLUE(0x0000FF){
        override fun toString(): String {
            println("this is a enum const $name")
            return super.toString()
        }

        override fun print() {
            println("this is a enum const $name  fun print")
        }
    },GREEN(0x00FF00){
        override fun print() {
            println("this is a enum const $name  fun print")
        }
    },WHITE(0xFFFFFF){
        override fun print() {
            println("this is a enum const $name  fun print")
        }
    },BLACK(0X000000){
        override fun print() {
            println("this is a enum const $name  fun print")
        }
    };

    abstract fun print()
}

