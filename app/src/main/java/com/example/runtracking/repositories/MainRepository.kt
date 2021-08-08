package com.example.runtracking.repositories

import com.example.runtracking.db.Run
import com.example.runtracking.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDAO: RunDAO
) {

    suspend fun insertRun(run : Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run : Run) = runDAO.deleteRun(run)

    fun getAllRunsSortedByDate() = runDAO.getAllRunsSortedByDate()

    fun getAllRunsSortedByCaloriesBurned() = runDAO.getAllRunsSortedByCaloriesBurned()

    fun getAllRunsSortedByAvgSpeed() = runDAO.getAllRunsSortedByAvgSpeed()

    fun getAllRunsSortedByDistanceInMeters() = runDAO.getAllRunsSortedByDistanceInMeters()

    fun getAllRunsSortedByTimeInMillis() = runDAO.getAllRunsSortedByTimeInMillis()

    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()

    fun getTotalDistance() = runDAO.getTotalDistance()

    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()
}