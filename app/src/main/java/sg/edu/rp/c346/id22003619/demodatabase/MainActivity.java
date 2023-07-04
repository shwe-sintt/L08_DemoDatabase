package sg.edu.rp.c346.id22003619.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        Button btnInsert, btnGetTasks;
        TextView tvResults;
        ListView lvTasks;
EditText etTask;
EditText etDate;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btnInsert = findViewById(R.id.btnInsert);
            btnGetTasks = findViewById(R.id.btnGetTasks);
            tvResults = findViewById(R.id.tvResults);
            lvTasks=findViewById(R.id.lv);
            etTask=findViewById(R.id.etTask);
            etDate=findViewById(R.id.etDate);

            btnInsert.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // Create the DBHelper object, passing in the
                    // activity's Context
                    DBHelper db = new DBHelper(MainActivity.this);

                    // Insert a task
                    String strTask= etTask.getText().toString();
                    String strDate= etDate.getText().toString();
                    db.insertTask(strTask, strDate);

                }
            });
            btnGetTasks.setOnClickListener(v -> {
                    // Create the DBHelper object, passing in the
                    // activity's Context
                    DBHelper db = new DBHelper(MainActivity.this);

                    // Insert a task
                    ArrayList<String> data = db.getTaskContent();
                    ArrayList<Task> data2 = db.getTasks();

                db.close();

                    String txt = "";
                    for (int i = 0; i < data.size(); i++) {
                        Log.d("Database Content", i +". "+data.get(i));
                        txt += i + ". " + data.get(i) + "\n";
                    }
                ArrayAdapter adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data2);
                lvTasks.setAdapter(adapter);
                tvResults.setText(txt);


            });

        }
    }

