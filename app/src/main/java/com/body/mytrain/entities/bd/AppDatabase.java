package com.body.mytrain.entities.bd;


import com.body.mytrain.entities.bd.person.Person;
import com.body.mytrain.entities.bd.person.PersonDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao getPersonDao();
}
