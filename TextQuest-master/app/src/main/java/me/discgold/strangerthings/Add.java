package me.discgold.strangerthings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    OneTable oneTable = new OneTable();

    public TextView textView_about1;

    private static final String TAG = "MainActivity";

    private AdView mAdView;


    public int line = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad);
        final TextView textView_about1 = (TextView)findViewById(R.id.textView_about1);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textView_about1.setText(oneTable.onescenario_ru[20]);



        Button button_back_to_start = (Button)findViewById(R.id.button_back_to_start);
        button_back_to_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent (Add.this, MainActivity.class);
                    startActivity(intent);finish();
                } catch (Exception e) {

                }
            }
        });

        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //системная кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent (Add.this, MainActivity.class);
            startActivity(intent);finish();
        } catch (Exception e) {

        }
    }
    //системная кнопка "Назад" - конец
}
