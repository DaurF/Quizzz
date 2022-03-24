package spacef.dauren.quizzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EasyLevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_level);

        Button btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EasyLevel.this, PlayMenu.class);
                    startActivity(intent);
                } catch(Exception e) {/* EMPTY */}
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Button to go to the first level - start
        TextView tv = (TextView)findViewById(R.id.TextView1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EasyLevel.this, EasyLevel1.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) { /* EMPTY */}

            }
        });
        // Button to go to the first level - end

    }
}
