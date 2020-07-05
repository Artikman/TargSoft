package com.example.cat.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.cat.data.Vote

@Dao
 abstract class VoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertVote(vote :Vote)
}