package project.n01356135.ryan

import androidx.room.*

@Dao
interface ScoreDao {
    @Query("SELECT * FROM scoreboard")
    fun getAll(): List<ScoreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(scoreboard: ScoreEntity)

    @Query("DELETE FROM scoreboard")
    fun deleteAll();
}