package com.body.mytrain.mvp.trainstreetprogram.presenter;

import com.body.mytrain.R;
import com.body.mytrain.entities.TrainProgramElement;
import com.body.mytrain.entities.TrainStreetElement;
import com.body.mytrain.mvp.trainstreetprogram.contract.TrainStreetProgramContract;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

public class TrainStreetProgramPresenter implements TrainStreetProgramContract.ITrainStreetProgramPresenter {



    @Override
    public List<IFlexible> initDataOnRecyclerView1Level() {
        List<IFlexible> firstDayTrainProgram = new ArrayList<>();
        firstDayTrainProgram.add(new TrainStreetElement("1","Разминка", "10 мин"));
        firstDayTrainProgram.add(new TrainStreetElement("2", "Отжимания с колен", "2x8"));
        firstDayTrainProgram.add(new TrainStreetElement("3", "Обратные отжимания", "3x8"));
        firstDayTrainProgram.add(new TrainStreetElement("4", "Австралийские подтягивания", "3х макс."));
        firstDayTrainProgram.add(new TrainStreetElement("5", "Приседания на возвышение", "2х12"));
        firstDayTrainProgram.add(new TrainStreetElement("6", "Приседания-пистолеты на возвышение", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("7", "Подъем коленей до прямого угла", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("8", "Планка но коленях", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("9", "Заминка", "10 мин"));
        return firstDayTrainProgram;
    }

    @Override
    public List<IFlexible> initDataOnRecyclerView2Level() {
        List<IFlexible> firstDayTrainProgram = new ArrayList<>();
        firstDayTrainProgram.add(new TrainStreetElement("1","Разминка", "10 мин"));
        firstDayTrainProgram.add(new TrainStreetElement("2", "Отжимания от опоры", "2x8"));
        firstDayTrainProgram.add(new TrainStreetElement("3", "Эксцентрические отжимания", "3x8"));
        firstDayTrainProgram.add(new TrainStreetElement("4", "Эксцентрические подтягивания", "3х макс."));
        firstDayTrainProgram.add(new TrainStreetElement("5", "Классические приседания", "2х12"));
        firstDayTrainProgram.add(new TrainStreetElement("6", "Приседания-пистолеты с опорой на стойку", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("7", "Подъём коленей к груди", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("8", "Планка на предплечьях", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("9", "Заминка", "10 мин"));
        return firstDayTrainProgram;
    }

    @Override
    public List<IFlexible> initDataOnRecyclerView3Level() {
        List<IFlexible> firstDayTrainProgram = new ArrayList<>();
        firstDayTrainProgram.add(new TrainStreetElement("1","Разминка", "10 мин"));
        firstDayTrainProgram.add(new TrainStreetElement("2", "Классические отжимания", "2x8"));
        firstDayTrainProgram.add(new TrainStreetElement("3", "Классические отжимания на брусьях", "3x8"));
        firstDayTrainProgram.add(new TrainStreetElement("4", "Классические подтягивания", "3х макс."));
        firstDayTrainProgram.add(new TrainStreetElement("5", "Приседания с прыжком", "2х12"));
        firstDayTrainProgram.add(new TrainStreetElement("6", "Классические пистолетики", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("7", "Подъём ног к турнику", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("8", "Классическая планка", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("9", "Заминка", "10 мин"));
        return firstDayTrainProgram;
    }

    @Override
    public List<IFlexible> initDataOnRecyclerView4Level() {
        List<IFlexible> firstDayTrainProgram = new ArrayList<>();
        firstDayTrainProgram.add(new TrainStreetElement("1","Разминка", "10 мин"));
        firstDayTrainProgram.add(new TrainStreetElement("2", "Усложнённые отжимания", "2x8"));
        firstDayTrainProgram.add(new TrainStreetElement("3", "Отжимания с отталкиванием", "3x8"));
        firstDayTrainProgram.add(new TrainStreetElement("4", "Подтягивания с узким и широким хватами", "3х макс."));
        firstDayTrainProgram.add(new TrainStreetElement("5", "Приседания с прыжком", "2х12"));
        firstDayTrainProgram.add(new TrainStreetElement("6", "Пистолетики с палкой над головой", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("7", "Подъём ног к турнику с замедлением", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("8", "Простая и боковая планки", "3 отказных сета"));
        firstDayTrainProgram.add(new TrainStreetElement("9", "Заминка", "10 мин"));
        return firstDayTrainProgram;
    }


}
