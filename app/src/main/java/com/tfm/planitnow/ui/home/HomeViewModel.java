package com.tfm.planitnow.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tfm.planitnow.models.Plan;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private List<Plan> planList;

    public HomeViewModel() {
        planList = new ArrayList<Plan>();
        test1_init();
    }

    public void setPlanList(List<Plan> planList){
        this.planList = planList;
    }

    public void addPlan(Plan p){
        planList.add(0,p);
    }

    public void deletePlan(Plan p) { planList.removeIf(pl -> (pl.getId() == p.getId())); }


    public void test1_init(){
        addPlan(new Plan(1, "Hacer música con Clau en el Piso", "De 18:00 a 19:00","El pisito"));
        addPlan(new Plan(2, "Ir a casa de Ale", "A las 19:00","Torres de Serrano"));
        addPlan((new Plan(3, "Despedida del pisito", "Martes a las 20:00 me voy del piso","El pisito")));
        addPlan((new Plan(4, "KafCafe Open Mic", "Micro abierto en el KafCafé")));
        addPlan((new Plan(5, "Guitarreo en la Playa", "Guitarrita!")));
        addPlan((new Plan(6, "Siesta en el Piso", "Siesta time!")));
        addPlan((new Plan(7, "Quedada para montar en long", "Guitarrita!")));
        addPlan((new Plan(8, "Cervezas en el Bar", "¡Que venga quien quiera!")));
        addPlan((new Plan(8, "Cervezas en el Bar", "¡Que venga quien quiera!")));
        addPlan((new Plan(8, "Cervezas en el Bar", "¡Que venga quien quiera!")));
        addPlan((new Plan(8, "Cervezas en el Bar", "¡Que venga quien quiera!")));
        addPlan((new Plan(8, "Cervezas en el Bar", "¡Que venga quien quiera!")));
    }
    public List<Plan> getPlanList(){ return planList; }

    public LiveData<String> getText() {
        return mText;
    }
}