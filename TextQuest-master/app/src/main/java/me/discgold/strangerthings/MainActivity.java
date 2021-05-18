package me.discgold.strangerthings;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // сообщает телефону, что у того есть экран activity_main
        // и выполняет xml
        setContentView(R.layout.activity_main);
        // находит кнопку с id buttonStart

        //save
       SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
       final int level = save.getInt("Save",1);




        final Button buttonStart = (Button)findViewById(R.id.buttonStart);
        // нажимает на кнопку
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                buttonStart.setTextColor(getResources().getColor(R.color.blue));

                    Intent intent = new Intent (MainActivity.this, Level1.class);
                    // переход с главной страницы на level1
                    startActivity(intent);finish();

            }
        });

        final Button continueGame = (Button)findViewById(R.id.continueGame);
        // нажимает на кнопку
        continueGame.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                continueGame.setTextColor(getResources().getColor(R.color.blue));
                switch (level)
                {
                    case 0: try {
                        Intent intent = new Intent (MainActivity.this, Level1.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 1: try {
                        Intent intent = new Intent (MainActivity.this, Level2.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 2: try {
                        Intent intent = new Intent (MainActivity.this, Level3.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 3: try {
                        Intent intent = new Intent (MainActivity.this, Level4.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 4: try {
                        Intent intent = new Intent (MainActivity.this, Level5.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 5: try {
                        Intent intent = new Intent (MainActivity.this, Level6.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 6: try {
                        Intent intent = new Intent (MainActivity.this, Level7.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 7: try {
                        Intent intent = new Intent (MainActivity.this, Level8.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    case 8: try {
                        Intent intent = new Intent (MainActivity.this, Level9.class); startActivity(intent);finish();
                    } catch (Exception e) {}break;
                    default: break;
                }

            }
        });

        final Button newGame = (Button)findViewById(R.id.newGame);
        // нажимает на кнопку
        newGame.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                newGame.setTextColor(getResources().getColor(R.color.blue));
                SharedPreferences save=getSharedPreferences("Save", MODE_PRIVATE);
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level",0);
                editor.commit();
                Intent intent = new Intent (MainActivity.this, Level1.class);
                // переход с главной страницы на level1
                startActivity(intent);finish();

            }
        });

        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        switch (level)
        {
            case 0: buttonStart.setVisibility(View.VISIBLE);
                continueGame.setVisibility(View.GONE);
                newGame.setVisibility(View.GONE);break;
            default: buttonStart.setVisibility(View.GONE);
                continueGame.setVisibility(View.VISIBLE);
                newGame.setVisibility(View.VISIBLE);break;
        }

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast =Toast.makeText(getBaseContext(), "Press again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
