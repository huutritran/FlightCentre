package com.example.fightcentre.domain

abstract class UseCase<in Param, out Type> {

    abstract operator fun invoke(param: Param): Type

    class None
}