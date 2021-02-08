package project.n01356135.ryan

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [ScoreEntity::class], version = 1)
abstract class ScoreboardDatabase : RoomDatabase() {
    abstract fun scoreDao():ScoreDao

    companion object {

        @Volatile
        private var INSTANCE: ScoreboardDatabase? = null

        fun getInstance(context: Context): ScoreboardDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ScoreboardDatabase::class.java,
                    "scoreboard.db")
                    .build()
            }
            return INSTANCE as ScoreboardDatabase
        }
    }
}