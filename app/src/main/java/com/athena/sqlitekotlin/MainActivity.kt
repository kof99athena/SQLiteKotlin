package com.athena.sqlitekotlin

import android.database.sqlite.SQLiteDatabase
import com.athena.sqlitekotlin.databinding.ActivityMainBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding //뷰바인딩 lateinit으로 만들기

    private val SQL_CREATE_ENTRIES=
        "CREATE TABLE ${FeedReaderContract.FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${FeedReaderContract.FeedEntry.NAME} TEXT," +
                "${FeedReaderContract.FeedEntry.EMAIL} TEXT,"+
                "${FeedReaderContract.FeedEntry.CITY} TEXT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedReaderContract.FeedEntry.TABLE_NAME}"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)//bindind이 잡고있는 린니어레이아웃을 연결한다.

    }

}

object FeedReaderContract{
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "customer"
        const val NAME = "name"
        const val EMAIL = "email"
        const val CITY = "city"
    }
}