package com.example.omramconstruction.ui.home;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.omramconstruction.R;
import com.example.omramconstruction.welcomegridview.*;

public class Home extends Fragment implements View.OnClickListener {

    Context context;
    Button labour, mistri , addlabour, addmistri, attendance, wagesrecord, updatelm, deletelm,sites;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        context = getActivity();
        labour = (Button) view.findViewById(R.id.labour);
        mistri = (Button) view.findViewById(R.id.mistri);
        addlabour = (Button)view.findViewById(R.id.addlabour);
        addmistri = (Button)view.findViewById(R.id.addmistri);
        attendance =(Button) view.findViewById(R.id.attendance);
        wagesrecord = (Button)view.findViewById(R.id.wagesrecord);
        updatelm = (Button)view.findViewById(R.id.updatelm);
        deletelm= (Button)view.findViewById(R.id.deletelm);
        sites =(Button) view.findViewById(R.id.sites);
//        sql = (Button)view.findViewById(R.id.btn9);


        labour.setOnClickListener(this);
        mistri.setOnClickListener(this);
        addlabour.setOnClickListener(this);
        addmistri.setOnClickListener(this);
        attendance.setOnClickListener(this);
        wagesrecord.setOnClickListener(this);
        updatelm.setOnClickListener(this);
        deletelm.setOnClickListener(this);
        sites.setOnClickListener(this);
//        sql.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.labour: {
                //Labour
                java.lang.String Btext= "Labour View";
                java.lang.String Burl="http://rajatconstructor.rf.gd/labour/retrive_labour.php";
                Toast.makeText(view.getContext(),"Loading Labour view",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Labourweb.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;
            }
            case R.id.mistri: {
                // Mistri
                java.lang.String Btext= "Labour View";
                java.lang.String Burl="http://rajatconstructor.rf.gd/mistri/retrieve_mistri/Retrieve_mistri.php";
                Toast.makeText(view.getContext(),"Loading Labour view",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Labourweb.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;

            }
            case R.id.addlabour: {
                //Add Labour
                java.lang.String Btext= "Add Labour View";
                java.lang.String Burl="http://rajatconstructor.rf.gd/labour/addlabour.php";
                Toast.makeText(view.getContext(),"Loading Add Labour Page",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Addlabourweb.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;

            }
            case R.id.addmistri: {
                // Add mistri
                java.lang.String Btext= "Add Mistri View";
                java.lang.String Burl="http://rajatconstructor.rf.gd/mistri/addMistri.php";
                Toast.makeText(view.getContext(),"Loading Add Mistri Page",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Addlabourweb.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;

            }
            case R.id.attendance: {
                // attendance
                java.lang.String Btext= "Attendance Page";
                Toast.makeText(context, "Loading Attendance Page", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(view.getContext(), Attendance.class);
                intent.putExtra("mytext",Btext);
                startActivity(intent);
                //getActivity().finish();
                break;

            }
            case R.id.wagesrecord: {
                // wages
                java.lang.String Btext= "Daily Wages";
                java.lang.String Burl="http://rajatconstructor.rf.gd/labour/wagesrecord/retrieve.php";
                Toast.makeText(view.getContext(),"Loading Daily Wages Page",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Addlabourweb.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;
            }
            case R.id.updatelm: {
                // update
                java.lang.String Btext= "Update Data";
                java.lang.String Burl="http://rajatconstructor.rf.gd/labour/updatelabour/retrive_labour.php";
                Toast.makeText(view.getContext(),"Loading Daily Wages Page",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Addlabourweb.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;
            }
            case R.id.deletelm: {
                // delete
                java.lang.String Btext= "Delete Data";
                java.lang.String Burl="http://rajatconstructor.rf.gd/labour/deletelabour/retrive_labour.php";
                Toast.makeText(view.getContext(),"Loading Daily Wages Page",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Addlabourweb.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                startActivity(myIntent);
                break;
            }
            case R.id.sites: {
                // Sites
                java.lang.String Btext= "Site Details";
                java.lang.String Burl="http://rajatconstructor.rf.gd/sites/addsites/addsites.php";
                Toast.makeText(view.getContext(),"Loading Sites Page",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(view.getContext(), Sitesdataupload.class);
                myIntent.putExtra("mytext",Btext);
                myIntent.putExtra(EXTRA_MESSAGE,Burl);
                myIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivity(myIntent);
                break;
//            }
//            case R.id.btn9:
//                // SQL
//                Toast.makeText(context, "Loading SQL", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(view.getContext(), Sql.class);
//                startActivity(intent);
//                break;
            }

        }

    }

}
