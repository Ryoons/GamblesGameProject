package project.n01356135.ryan

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scoreboard")
data class ScoreEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "name")
    var fullName: String,

    @ColumnInfo(name = "score")
    var balanceScore: Int
)