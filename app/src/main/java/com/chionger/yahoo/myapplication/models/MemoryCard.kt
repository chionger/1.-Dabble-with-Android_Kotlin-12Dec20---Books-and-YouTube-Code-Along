package com.chionger.yahoo.myapplication.models

import android.service.carrier.CarrierIdentifier
import org.intellij.lang.annotations.Identifier

data class MemoryCard (
    val identifier: Int,
    val isFaceUp: Boolean = false,
    var isMatched: Boolean = false
)