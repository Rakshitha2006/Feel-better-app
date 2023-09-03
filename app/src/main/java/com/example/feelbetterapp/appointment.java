package com.example.feelbetterapp;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.NotificationCompat;
        import androidx.core.app.NotificationManagerCompat;

        import android.app.DatePickerDialog;
        import android.app.TimePickerDialog;
        import android.content.Intent;
        import android.view.View;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.os.Bundle;
        import android.widget.TimePicker;
        import android.widget.Toast;
        import android.widget.Button;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.TimeZone;

public class appointment extends AppCompatActivity {
    EditText dateformat;
    TimePickerDialog timePickerDialog;
    int year;
    int month;
    int day;
    int currentHour;
    int currentMinute;

    Calendar calendar;

    EditText timeformat;
    Button button;
    String amPm;
    Button btnfeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        dateformat = findViewById(R.id.dateformatid);
        timeformat = findViewById(R.id.timeformatid);
        button=findViewById(R.id.btnfix);
        btnfeed=findViewById(R.id.feedbackbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(appointment.this, "Appointment sucessfully submitted will reach you soon!!", Toast.LENGTH_SHORT).show();
            }

        });


        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(appointment.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        timeformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(appointment.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        timeformat.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        btnfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),feedback.class);
                startActivity(intent);
            }
        });

    }
}


