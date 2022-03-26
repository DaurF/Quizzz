package spacef.dauren.quizzz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class EasyLevel2 extends AppCompatActivity {

    private Button button_back;
    Dialog dialog;
    Dialog dialogBack;
    Dialog dialogEnd;

    public int numLeft; // Variable for left image
    public int numRight; // Variable for right image
    Array array = new Array(); // Created a new object of class "array"
    Random random = new Random(); // To generate random numbers
    public int count = 0;

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
        dialogBack = new Dialog(EasyLevel2.this);
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
                    Intent intent = new Intent(EasyLevel2.this, EasyLevel.class);
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


        // Calling a dialog box when the user passes the level - start
        dialogEnd = new Dialog(EasyLevel2.this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialog_end);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);

        TextView btn_close_end = (TextView)dialogEnd.findViewById(R.id.btn_close);
        btn_close_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EasyLevel2.this, EasyLevel.class);
                    startActivity(intent);
                    finish();
                } catch(Exception e) { /* EMPTY */}
                dialogEnd.dismiss();
            }
        });

        Button btn_continue_end = (Button)dialogEnd.findViewById(R.id.btn_continue);
        btn_continue_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EasyLevel2.this, EasyLevel2.class);
                    startActivity(intent);
                    finish();
                } catch(Exception e) {/* EMPTY */}
                dialogEnd.dismiss();
            }
        });
        // Calling a dialog box when the user passes the level - end

        // Calling a dialog box at the beginning of the game - start
        dialog = new Dialog(this); // Creating a new dialog box
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Hiding title
        dialog.setContentView(R.layout.previewdialog); // Path to dialog layout
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Transparent dialog box background
        dialog.setCancelable(false); // Window cannot be closed with system button "Back"

        // Set image to dialog box - start
        ImageView preview_img = (ImageView)dialog.findViewById(R.id.preview_img);
        preview_img.setImageResource(R.drawable.previewimgtwo);
        // Set image to dialog box - end

        // Set text to dialog box - start
        TextView text_description = (TextView)dialog.findViewById(R.id.text_description);
        text_description.setText(R.string.level_two);
        // Set text to dialog box - end

        // Button that closes the dialog box - start
        TextView btn_close = (TextView)dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handling a button click - start
                try {
                    // Go back to level selection - start
                    Intent intent = new Intent(EasyLevel2.this, EasyLevel.class); // Created a transition intent
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

        // Array for game progress - start
        final int[] progress = {
                R.id.range1, R.id.range2, R.id.range3, R.id.range4,
                R.id.range5, R.id.range6, R.id.range7, R.id.range8,
                R.id.range9, R.id.range10, R.id.range11, R.id.range12,
                R.id.range13, R.id.range14, R.id.range15, R.id.range16,
        };
        // Array for game progress - end

        // Connect animation - start
        final Animation a = AnimationUtils.loadAnimation(EasyLevel2.this, R.anim.alpha);
        // Connect animation - end

        numLeft = random.nextInt(10); // Generating random number from 0 to 9
        img_left.setImageResource(array.images1[numLeft]);

        numRight = random.nextInt(10); // Generating random number from 0 to 9
        while(numRight == numLeft) {
            numRight = random.nextInt(10);
        }

        img_right.setImageResource(array.images1[numRight]);

        // Handle clicking on the left image - start
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Picture touch condition - start
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    // If you touched the picture - start
                    img_right.setEnabled(false); // Block right image
                    if (numLeft > numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    // If you touched the picture - end

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    // If you let go of your finger - start
                    if(numLeft > numRight) {
                        // If the left image is larger - start
                        if (count < 16) {
                            count = count + 1;
                        }

                        // Color progress in grey - start
                        for(int i = 0; i < 16; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_ranges);
                        }
                        // Color progress in grey - end

                        // Identify the correct answers and color in green - start
                        for(int i = 0; i < count; i++) {
                            findViewById(progress[i]).setBackgroundResource(R.drawable.style_ranges_green);
                        }
                        // Identify the correct answers and color in green - end

                        // If the left image is larger - end
                    } else {
                        // If the left image is less - start

                        if (count < 2) {
                            count = 0;
                        } else {
                            count = count - 2;
                        }

                        // Color progress in gray - start
                        for(int i = 0; i < 15; i++) {
                            findViewById(progress[i]).setBackgroundResource(R.drawable.style_ranges);
                        }
                        // Color progress in gray - end

                        // Identify the correct answers and color in green - start
                        for(int i = 0; i < count; i++) {
                            findViewById(progress[i]).setBackgroundResource(R.drawable.style_ranges_green);
                        }
                        // Identify the correct answers and color in green - end

                        // If the left image is less - end
                    }
                    // If you let go of your finger - end

                        if (count == 16) {
                            // EXIT LEVEL
                            dialogEnd.show();
                        } else {
                            numLeft = random.nextInt(10); // Generating random number from 0 to 9
                            img_left.setImageResource(array.images1[numLeft]);
                            img_left.startAnimation(a);

                            numRight = random.nextInt(10); // Generating random number from 0 to 9
                            while(numRight == numLeft) {
                                numRight = random.nextInt(10);
                            }

                            img_right.setImageResource(array.images1[numRight]);
                            img_right.startAnimation(a);

                            img_right.setEnabled(true); // Turn right image back on
                        }
                }
                // Picture touch condition - end

                return true;
            }
        });
        // Handle clicking on the left image - end

        // Handle clicking on the right image - start
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Picture touch condition - start
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    // If you touched the picture - start
                    img_left.setEnabled(false); // Block right image
                    if (numLeft < numRight) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    // If you touched the picture - end

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    // If you let go of your finger - start
                    if(numLeft < numRight) {
                        // If the left image is larger - start
                        if (count < 16) {
                            count = count + 1;
                        }

                        // Color progress in grey - start
                        for(int i = 0; i < 16; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_ranges);
                        }
                        // Color progress in grey - end

                        // Identify the correct answers and color in green - start
                        for(int i = 0; i < count; i++) {
                            findViewById(progress[i]).setBackgroundResource(R.drawable.style_ranges_green);
                        }
                        // Identify the correct answers and color in green - end

                        // If the left image is larger - end
                    } else {
                        // If the left image is less - start

                        if (count < 2) {
                            count = 0;
                        } else {
                            count = count - 2;
                        }

                        // Color progress in gray - start
                        for(int i = 0; i < 15; i++) {
                            findViewById(progress[i]).setBackgroundResource(R.drawable.style_ranges);
                        }
                        // Color progress in gray - end

                        // Identify the correct answers and color in green - start
                        for(int i = 0; i < count; i++) {
                            findViewById(progress[i]).setBackgroundResource(R.drawable.style_ranges_green);
                        }
                        // Identify the correct answers and color in green - end

                        // If the left image is less - end
                    }
                    // If you let go of your finger - end

                    if (count == 16) {
                        // EXIT LEVEL
                        dialogEnd.show();

                    } else {
                        numLeft = random.nextInt(10); // Generating random number from 0 to 9
                        img_left.setImageResource(array.images1[numLeft]);
                        img_left.startAnimation(a);

                        numRight = random.nextInt(10); // Generating random number from 0 to 9
                        while(numRight == numLeft) {
                            numRight = random.nextInt(10);
                        }

                        img_right.setImageResource(array.images1[numRight]);
                        img_right.startAnimation(a);

                        img_left.setEnabled(true); // Turn right image back on
                    }
                }
                // Picture touch condition - end

                return true;
            }
        });
        // Handle clicking on the left image - end
    }
    // Set system button "Back" - start
    @Override
    public void onBackPressed() {
        dialogBack.show();
    }
    // Set system button "Back" - end
}