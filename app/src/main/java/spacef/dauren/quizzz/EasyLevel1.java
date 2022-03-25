package spacef.dauren.quizzz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class EasyLevel1 extends AppCompatActivity {

    private Button button_back;
    Dialog dialog;
    Dialog dialogBack;

    public int numLeft; // Variable for left image
    public int numRight; // Variable for right image
    Array array = new Array(); // Created a new object of class "array"
    Random random = new Random(); // To generate random numbers

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


        // Calling a dialog box when the user presses the back button - start
        dialogBack = new Dialog(EasyLevel1.this);
        dialogBack.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBack.setContentView(R.layout.previewdialog_back);
        dialogBack.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBack.setCancelable(true);

        // Button that closes the "dialog back" box - start
        Button btn_cancel = (Button)dialogBack.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialogBack.dismiss();
                } catch(Exception e) { /* EMPTY */}
            }
        });
        // Button that closes the "dialog back" box - end

        // Button "Ok" - start
        Button btn_ok = (Button)dialogBack.findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handling a button click - start
                try {
                    // Go back to level selection - start
                    Intent intent = new Intent(EasyLevel1.this, EasyLevel.class);
                    startActivity(intent);
                    finish();
                    // Go back to level selection - end
                } catch(Exception e) { /* EMPTY */}
                // Handling a button click - end
                dialogBack.dismiss();
            }
        });
        // Button "Ok" - end

        button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBack.show(); // Show dialog back box
            }
        });
        // Calling a dialog box when the user presses the back button - end


        // Calling a dialog box at the beginning of the game - start
        dialog = new Dialog(this); // Creating a new dialog box
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Hiding title
        dialog.setContentView(R.layout.previewdialog); // Path to dialog layout
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Transparent dialog box background
        dialog.setCancelable(false); // Window cannot be closed with system button "Back"

        // Button that closes the dialog box - start
        TextView btn_close = (TextView)dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handling a button click - start
                try {
                    // Go back to level selection - start
                    Intent intent = new Intent(EasyLevel1.this, EasyLevel.class); // Created a transition intent
                    startActivity(intent); // Start intention
                    finish(); // Close this class
                    // Go back to level selection - end
                } catch(Exception e) {/* EMPTY */}
                // Handling a button click - end
                dialog.dismiss();
            }
        });
        // Button that closes the dialog box - end



        // Button "Continue" - start
        Button btn_continue = (Button)dialog.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                } catch(Exception e) {/* EMPTY */}
            }
        });
        // Button "Continue" - end

        dialog.show(); // Show dialog box
        // Calling a dialog box at the beginning of the game - end

        numLeft = random.nextInt(10); // Generating random number from 0 to 9
        img_left.setImageResource(array.images1[numLeft]);

        numRight = random.nextInt(10); // Generating random number from 0 to 9
        while(numRight == numLeft) {
            numRight = random.nextInt(10);
        }

        img_right.setImageResource(array.images1[numRight]);
    }
    // Set system button "Back" - start
    @Override
    public void onBackPressed() {
        dialogBack.show();
    }
    // Set system button "Back" - end
}