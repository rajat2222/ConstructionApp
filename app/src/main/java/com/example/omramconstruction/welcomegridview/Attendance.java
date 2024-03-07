package com.example.omramconstruction.welcomegridview;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omramconstruction.R;
import com.example.omramconstruction.WelcomeActivity;

public class Attendance extends AppCompatActivity implements View.OnClickListener {
Button Takeattendance, ShowAttendance, close;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        textView=(TextView) findViewById(R.id.txt1);

        textView.setText(getIntent().getStringExtra("mytext"));

        Takeattendance = (Button)findViewById(R.id.takeattendance);
        ShowAttendance = (Button)findViewById(R.id.showattendance);
        close = (Button)findViewById(R.id.btnclose);

        Takeattendance.setOnClickListener(this);
        ShowAttendance.setOnClickListener(this);
        close.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.takeattendance: {
                java.lang.String Btext= "Take Attendance";
                java.lang.String Burl="http://rajatconstructor.rf.gd/labour/attendance/LabourAttendance.php";
                Toast.makeText(view.getContext(),"Loading Take Attendance Page",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Attendancewebview.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;
                }

            case R.id.showattendance: {
            // Show Attendance
            java.lang.String Btext= "Show Attendance";
            java.lang.String Burl="http://rajatconstructor.rf.gd/labour/attendance/showAttendance.php";
            Toast.makeText(view.getContext(),"Loading Show Attendance Page",Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(view.getContext(), Attendancewebview.class);
            myIntent.putExtra("mytext",Btext);
            myIntent.putExtra(EXTRA_MESSAGE,Burl);
            startActivity(myIntent);
            break;

            }
            case R.id.btnclose: {
            // Close Activity

            finish();
            break;

        }

        }

    }
}