package com.example.myjavaroomdb.roomDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Query("delete from Student where id=:id")
    void delete(int id);

    @Query("Select * from Student")
    List<Student> getAll();

}
