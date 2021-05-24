package io.github.dowhep.HelperClasses;

import java.util.ArrayList;

import io.github.dowhep.AbstractClasses.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public final class Data {
    private ObservableList<Pie> pies = FXCollections.observableList(new ArrayList<Pie>());
    private Pie temp = new Pie();

    private final static Data INSTANCE = new Data();

    private Data() {
    }

    public static Data getInstance() {
        return INSTANCE;
    }

    public int getNumberOfPies() {
        return pies.size();
    }

    public Pie getPie() {
        return temp;
    }

    public static void main(String[] args) {
        INSTANCE.pies.addListener(new ListChangeListener<Pie>() {

            @Override
            public void onChanged(Change<? extends Pie> change) {
                System.out.println("Detected a change! ");
            }
        });
    }
}
