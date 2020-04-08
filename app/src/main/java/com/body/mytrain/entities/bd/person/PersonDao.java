package com.body.mytrain.entities.bd.person;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PersonDao {

    //Добавление в бд
    @Insert
    void insertAll(Person... people);

    //удаление из бд
    @Delete
    void delete(Person person);

    // получение всех Person из бд
    @Query("SELECT * FROM person")
    List<Person> getAllPeople();


}
