package com.vaibhav.delshop.dataClasses

import Dataclasses.Hit

data class Recipeclasses(
    val count: Int,
    val from: Int,
    val hits: List<Hit>,
    val more: Boolean,
    val q: String,
    val to: Int
)