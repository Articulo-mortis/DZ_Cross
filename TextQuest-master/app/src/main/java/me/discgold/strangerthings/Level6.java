package me.discgold.strangerthings;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class Level6 extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    Delay delay = new Delay();
    public Animation a;
    public TextView textView1;
    public TextView textView2;

    public ImageView imageView1;
    public Button button_1;
    public Button button_2;


    public int line = -1;
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_6);

        SharedPreferences save=getSharedPreferences("Save", MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putInt("Level",5);
        editor.commit();

        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        final TextView textView2 = (TextView)findViewById(R.id.textView2);

        final ImageView imageView1 = (ImageView) findViewById(R.id.level_four_image);
        final Button button_1 = (Button)findViewById(R.id.button_1);
        final Button button_2 = (Button)findViewById(R.id.button_2);



       /* textView1.setText(our_table.onescenario[0]);
        textView2.setText(our_table.onescenario[1]);
        textView3.setText(our_table.onescenario[4]);
        button_1.setText(our_table.onescenario[2]);
        button_2.setText(our_table.onescenario[3]);
        button_3.setText(our_table.onescenario[5]);
        button_4.setText(our_table.onescenario[6]);*/


        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);

        imageView1.setVisibility(View.INVISIBLE);
        button_1.setVisibility(View.GONE);
        button_2.setVisibility(View.GONE);

        //??????????????, ?????????????? ?????????????????? AsyncTask
        delay.execute();


        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //?? ?????????? ?????????? ???????????????????? ?????? AsyncTask
    class Delay extends AsyncTask<Void, Integer, Void>{

        @Override
            protected Void doInBackground(Void... params){
            while (line<=4){
                if (count == 0 && line == 4)
                    line = 3;
                publishProgress(line++);
                try{
                    Thread.sleep(2000);
                    if (isCancelled()) return null;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate (Integer... values){
        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        final TextView textView2 = (TextView)findViewById(R.id.textView2);
        final TextView textView3 = (TextView)findViewById(R.id.textView3);
        final ImageView imageView1 = (ImageView) findViewById(R.id.level_four_image);
        final Button button_1 = (Button)findViewById(R.id.button_1);
        final Button button_2 = (Button)findViewById(R.id.button_2);
        final Button button_3 = (Button)findViewById(R.id.button_3);

        final Animation a = AnimationUtils.loadAnimation(Level6.this, R.anim.alpha);

            switch(line){
                case 0: textView1.setVisibility(View.VISIBLE); textView1.startAnimation(a); break;
                case 1: imageView1.setVisibility(View.VISIBLE); imageView1.startAnimation(a); break;
                case 2: textView2.setVisibility(View.VISIBLE); textView2.startAnimation(a); break;
                case 3:
                    button_1.setVisibility(View.VISIBLE); button_1.startAnimation(a);
                    button_2.setVisibility(View.VISIBLE); button_2.startAnimation(a);
                    break;
                case 4:
                    button_1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (count==0) {
                                button_1.setTextColor(getResources().getColor(R.color.blue));
                                count = 1;
                                line = 5;
                                try {
                                    SharedPreferences save=getSharedPreferences("Save", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = save.edit();
                                    editor.putInt("Level",0);
                                    editor.commit();
                                    Intent intent = new Intent(Level6.this, Level3.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    button_2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (count==0) {
                                button_2.setTextColor(getResources().getColor(R.color.blue));
                                count = 1;
                                try {
                                    SharedPreferences save=getSharedPreferences("Save", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = save.edit();
                                    editor.putInt("Level",6);
                                    editor.commit();
                                    Intent intent = new Intent(Level6.this, Level7.class);
                                    startActivity(intent);
                                    finish();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    break;

                default: break;
            }
        }

    }


    //?????????????????? ???????????? "??????????" - ????????????
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent (Level6.this, MainActivity.class);
            startActivity(intent);finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
