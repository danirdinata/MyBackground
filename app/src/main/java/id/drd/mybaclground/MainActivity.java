package id.drd.mybaclground;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView loading;
    Button loadImage;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.progress);
        loading =(TextView)findViewById(R.id.load);
        loadImage = (Button)findViewById(R.id.btnLoad);
        loadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i<5000; i++){
                    sb.append( " Nama: Dani " + i +
                               " NPM : 193040191 " + i);
                }
                new MyAsyncTask().execute(sb.toString());
            }
        });
    }
    public class MyAsyncTask extends AsyncTask<String, Void, ArrayList<String>> {
        private ArrayList<String> list = new ArrayList<>();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading.setText("Loading...");
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            for (int i=0; i<params.length;i++) {
                list.add(params[i]);
            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            loading.setText(strings.toString()+ "\n");
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}


