package yeasin.hitechwebdesign.menucircle;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "CircleMenu";

    private FrameLayout content_main;
    private ImageView iv8;
    private ImageView iv7;
    private ImageView iv6;
    private ImageView iv5;
    private ImageView iv4;
    private ImageView iv3;
    private ImageView iv2;
    private ImageView iv1;

    private ImageView iv18;
    private ImageView iv17;
    private ImageView iv16;
    private ImageView iv15;
    private ImageView iv14;
    private ImageView iv13;
    private ImageView iv12;
    private ImageView iv11;
    private List<ImageView> imageViews = new ArrayList<>();
    private List<ImageView> imageViews2 = new ArrayList<>();
    private final int radius1 = 500;
    private final int radius2 = 300;

    private void assignViews() {
        content_main = (FrameLayout) findViewById(R.id.content_main);
        iv8 = (ImageView) findViewById(R.id.iv8);
        imageViews.add(iv8);
        iv7 = (ImageView) findViewById(R.id.iv7);
        imageViews.add(iv7);
        iv6 = (ImageView) findViewById(R.id.iv6);
        imageViews.add(iv6);
        iv5 = (ImageView) findViewById(R.id.iv5);
        imageViews.add(iv5);
        iv4 = (ImageView) findViewById(R.id.iv4);
        imageViews.add(iv4);
        iv3 = (ImageView) findViewById(R.id.iv3);
        imageViews.add(iv3);
        iv2 = (ImageView) findViewById(R.id.iv2);
        imageViews.add(iv2);
        iv1 = (ImageView) findViewById(R.id.iv1);

        iv18 = (ImageView) findViewById(R.id.iv18);
        imageViews2.add(iv18);
        iv17 = (ImageView) findViewById(R.id.iv17);
        imageViews2.add(iv17);
        iv16 = (ImageView) findViewById(R.id.iv16);
        imageViews2.add(iv16);
        iv15 = (ImageView) findViewById(R.id.iv15);
        imageViews2.add(iv15);
        iv14 = (ImageView) findViewById(R.id.iv14);
        imageViews2.add(iv14);
        iv13 = (ImageView) findViewById(R.id.iv13);
        imageViews2.add(iv13);
        iv12 = (ImageView) findViewById(R.id.iv12);
        imageViews2.add(iv12);
        iv11 = (ImageView) findViewById(R.id.iv11);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();

    }

    public void onClick(View v) {

        if (v.getId() == iv1.getId()) {
            Boolean isShowing = (Boolean) iv1.getTag();
            if (null == isShowing || isShowing == false) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv1, "rotation", 0, 45);
                objectAnimator.setDuration(500);
                objectAnimator.start();
                iv1.setTag(true);
                showSectorMenu();
            } else {
                iv1.setTag(false);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv1, "rotation", 45, 0);
                objectAnimator.setDuration(500);
                objectAnimator.start();
                closeSectorMenu();
            }
        } else if (v.getId() == iv11.getId()) {
            Boolean isShowing = (Boolean) iv11.getTag();
            if (null == isShowing || isShowing == false) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv11, "rotation", 0, 45);
                objectAnimator.setDuration(500);
                objectAnimator.start();
                iv11.setTag(true);
                showCircleMenu();
            } else {
                iv11.setTag(false);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv11, "rotation", 45, 0);
                objectAnimator.setDuration(500);
                objectAnimator.start();
                closeCircleMenu();
            }
        } else {
            Toast.makeText(this, "Position" + (imageViews.indexOf(v) == -1 ? imageViews2.indexOf(v) : imageViews.indexOf(v)) + "个", Toast.LENGTH_SHORT).show();
        }

    }
    private void showSectorMenu() {
        for (int i = 0; i < imageViews.size(); i++) {
            PointF point = new PointF();
            int avgAngle = (90 / (imageViews.size() - 1));
            int angle = avgAngle * i;
            Log.d(TAG, "angle=" + angle);
            point.x = (float) Math.cos(angle * (Math.PI / 180)) * radius1;
            point.y = (float) -Math.sin(angle * (Math.PI / 180)) * radius1;
            Log.d(TAG, point.toString());


            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews.get(i), "translationX", 0, point.x);
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageViews.get(i), "translationY", 0, point.y);

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500);
            animatorSet.play(objectAnimatorX).with(objectAnimatorY);
            animatorSet.start();
        }
    }
    private void closeSectorMenu() {
        for (int i = 0; i < imageViews.size(); i++) {
            PointF point = new PointF();
            int avgAngle = (90 / (imageViews.size() - 1));
            int angle = avgAngle * i;
            Log.d(TAG, "angle=" + angle);
            point.x = (float) Math.cos(angle * (Math.PI / 180)) * radius1;
            point.y = (float) -Math.sin(angle * (Math.PI / 180)) * radius1;
            Log.d(TAG, point.toString());

            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews.get(i), "translationX", point.x, 0);
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageViews.get(i), "translationY", point.y, 0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500);
            animatorSet.play(objectAnimatorX).with(objectAnimatorY);
            animatorSet.start();
        }
    }

    private void showCircleMenu() {
        for (int i = 0; i < imageViews2.size(); i++) {
            PointF point = new PointF();
            int avgAngle = (360 / (imageViews2.size() - 1));
            int angle = avgAngle * i;
            Log.d(TAG, "angle=" + angle);
            point.x = (float) Math.cos(angle * (Math.PI / 180)) * radius2;
            point.y = (float) Math.sin(angle * (Math.PI / 180)) * radius2;
            Log.d(TAG, point.toString());
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews2.get(i), "translationX", 0, point.x);
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageViews2.get(i), "translationY", 0, point.y);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500);
            animatorSet.play(objectAnimatorX).with(objectAnimatorY);
            animatorSet.start();
        }
    }
    private void closeCircleMenu() {
        for (int i = 0; i < imageViews2.size(); i++) {
            PointF point = new PointF();
            int avgAngle = (360 / (imageViews2.size() - 1));
            int angle = avgAngle * i;
            Log.d(TAG, "angle=" + angle);
            point.x = (float) Math.cos(angle * (Math.PI / 180)) * radius2;
            point.y = (float) Math.sin(angle * (Math.PI / 180)) * radius2;

            Log.d(TAG, point.toString());
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imageViews2.get(i), "translationX", point.x, 0);
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imageViews2.get(i), "translationY", point.y, 0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500);
            animatorSet.play(objectAnimatorX).with(objectAnimatorY);
            animatorSet.start();
        }
    }
}
