package com.example.skylite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.skylite.Activities.ActivityCalendar;
import com.example.skylite.Activities.ActivityConstellationInfo;
import com.example.skylite.Activities.ActivityTrophy;
import com.example.skylite.Model.ModelConstellationInfo;
import com.example.skylite.Model.ModelConstellationList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);
        switchToCalendarActivity();
    }

    public void goToActivity(View v){
        if(v.getId() == R.id.trophiesButton){
            switchToTrophyActivity();
        }
        else if(v.getId() == R.id.wikiButton){
            switchToConstellationListActivity();
            //TODO
        }
    }

    private void switchToTrophyActivity(){
        Intent intent = new Intent(this, ActivityTrophy.class);
        startActivity(intent);
    }

    private void switchToScrollingActivity(){
        //TODO
    }
    private void switchToConstellationListActivity(){
        //TODO: will be changed with backend integration -- this is simply to show how the UI flow is expected to work
        ModelConstellationInfo temp = new ModelConstellationInfo("trophy",
                "Example Title", "Description Short", "Description Long");
        ModelConstellationInfo temp1 = new ModelConstellationInfo("uncompleted_trophy",
                "Example Title1", "Description Short1", "Description Long1");

        ModelConstellationList modelConstellationList = new ModelConstellationList();

        modelConstellationList.addConstellationInfo(temp);
        modelConstellationList.addConstellationInfo(temp1);

        Intent intent = new Intent(this, ActivityConstellationInfo.class);
        intent.putExtra("ModelList", modelConstellationList);
        startActivity(intent);
    }

    private void switchToCalendarActivity(){
        Intent intent = new Intent(this, ActivityCalendar.class);
        startActivity(intent);
    }
}
