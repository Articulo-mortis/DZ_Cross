package me.discgold.strangerthings;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Level5 extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    OneTable oneTable = new OneTable();
    Delay delay = new Delay();
    public Animation a;
    public TextView textView1;
    public ImageView imageView1;
    public Button buttonNextLevel;

    public int line = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_5);
        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        final ImageView imageView1 = (ImageView) findViewById(R.id.level_one_image);
        final Button buttonNextLevel = (Button)findViewById(R.id.button_next_level);

        textView1.setText(oneTable.onescenario_ru[21]);

        buttonNextLevel.setText(oneTable.onescenario_ru[22]);

        //внизу будет код, который прячет текст
        textView1.setVisibility(View.INVISIBLE);
        imageView1.setVisibility(View.INVISIBLE);
        buttonNextLevel.setVisibility(View.INVISIBLE);
        //конец скрытия текста

        //команда, которая запускает AsyncTask
        delay.execute();
        //конец команды, которая запускает AsyncTask

        buttonNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent (Level5.this, Level3.class);
                    startActivity(intent);finish();
                } catch (Exception e) {

                }
            }
        });

        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //с этого места начинается код AsyncTask
    class Delay extends AsyncTask<Void, Integer, Void>{

        @Override
            protected Void doInBackground(Void... params){
            while (line<=2){
                publishProgress(line++);
                try{
                    Thread.sleep(4000);
                    if (isCancelled()) return null;
                }catch(Exception e){}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate (Integer... values){
        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        final ImageView imageView1 = (ImageView) findViewById(R.id.level_one_image);
        final Button buttonNextLevel = (Button)findViewById(R.id.button_next_level);

        final Animation a = AnimationUtils.loadAnimation(Level5.this, R.anim.alpha);

            switch(line){
                case 1: textView1.setVisibility(View.VISIBLE); textView1.startAnimation(a); break;
                case 2: imageView1.setVisibility(View.VISIBLE); imageView1.startAnimation(a); break;
                case 3: buttonNextLevel.setVisibility(View.VISIBLE); buttonNextLevel.startAnimation(a); break;
                default: break;
            }
        }

    }
    //с этого места заканчивается код AsyncTask

    //системная кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent (Level5.this, Level4.class);
            startActivity(intent);finish();
        } catch (Exception e) {

        }
    }
    //системная кнопка "Назад" - конец
}
