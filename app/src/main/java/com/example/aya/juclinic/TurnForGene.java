package com.example.aya.juclinic;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class TurnForGene extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button date;
    Button Time;
    Button reserve;
    Appointment appo=new Appointment();
    int count=0;
    // DatabaseReference databasestudent;
    DatabaseReference databaseAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_for_gene);
        Toolbar toolbar=findViewById(R.id.toolbar);

        date=(Button) findViewById(R.id.buDate);
        Time=(Button) findViewById(R.id.buTime);
        reserve=(Button) findViewById(R.id.Reserve);

        // databasestudent= FirebaseDatabase.getInstance().getReference("students");
        databaseAppointment= FirebaseDatabase.getInstance().getReference("Appointments");
        //add appointment
        reserve.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                count+=1;
                insertappointmenttofirebase();

            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("What's your Available Time?");
        //add back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //for date
        Button date=(Button) findViewById(R.id.buDate);
        Calendar c=Calendar.getInstance();
        String currentdate= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        date.setText(currentdate);

        //for time
        Button Time=(Button) findViewById(R.id.buTime);
        c=Calendar.getInstance();
        int hourOfDay=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);
        Time.setText(hourOfDay+" : "+minute);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker= new DatePickerFrragment();
                datepicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        //for time
        Button time=(Button) findViewById(R.id.buTime);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment TimePicker=new TimerPickerFragment();
                TimePicker.show(getSupportFragmentManager(),"TimePicker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentdate= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        Button date=(Button) findViewById(R.id.buDate);
        date.setText(currentdate);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
        c.set(Calendar.MINUTE,minute);

        Button Time=(Button) findViewById(R.id.buTime);
        Time.setText(hourOfDay+" : "+minute);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }
    public void insertappointmenttofirebase(){
        appo.setAppo_id("21");
        appo.setAppo_Department("General");
        appo.setAppo_time(Time.getText().toString());
        appo.setAppo_Date(date.getText().toString());

        if(count==1) {
            databaseAppointment.child(appo.getAppo_id()).push().setValue(appo);
            Toast.makeText(this, "Appointment Added Successful", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(this, "You Already Reserved an Appointment", Toast.LENGTH_LONG).show();

    }
}
