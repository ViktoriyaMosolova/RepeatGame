package com.example.exercise3.model

object Sequence {
    var base: MutableList<Int> = mutableListOf()
    private var index = -1

    init {
        setInitSequences()
    }

    fun setInitSequences() {
        base = mutableListOf()
        setSequenceForNextLevel()
    }

    fun setSequenceForNextLevel() {
        base.add(getRandomSequenceElement())
        index = -1
    }

    fun addElementToSequence(value: Int): TypeCompareSequence {
        index++
        return compareSequence(index, value)
    }

    private fun compareSequence(index: Int, value: Int): TypeCompareSequence {
        if((index+1) > base.size) return TypeCompareSequence.LOSE
        return when {
            base.size == (index+1) && base[index] == value -> TypeCompareSequence.WIN
            base[index] == value -> TypeCompareSequence.CONTINUE
            else -> TypeCompareSequence.LOSE
        }
    }

    private fun getRandomSequenceElement(): Int {
        val min = 0
        val max = 3
        return (min..max).random()
    }
}