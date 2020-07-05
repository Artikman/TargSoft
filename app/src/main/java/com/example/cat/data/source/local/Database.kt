package com.example.cat.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cat.data.Vote

@Database(
    entities = [Vote::class], version = 1
)
abstract class Database: RoomDatabase() {
    abstract fun votesDao(): VoteDao
}