package spacef.dauren.quizzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EasyLevel1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);


        // Round the corners of the left image - start
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        // Round the corners of the left image - end

        // Round the corners of the right image - start
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        // Round the corners of the right image - end

        // Expand the game to fullscreen - start
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Expand the game to fullscreen - end

        // Set OnClickListener to button "Back" - start
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EasyLevel1.this, EasyLevel.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) { /* EMPTY */}

            }
        });
        // Set OnClickListener to button "Back" - end
    }

    // Set system button "Back" - start

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EasyLevel1.this, EasyLevel.class);
        startActivity(intent);
        finish();
    }

    // Set system button "Back" - end
}