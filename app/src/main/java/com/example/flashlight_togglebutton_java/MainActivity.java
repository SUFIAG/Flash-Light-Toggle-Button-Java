package com.example.flashlight_togglebutton_java;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    ToggleButton mainButton;
    CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainButton = findViewById(R.id.toggleButton);

        mainButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    String idForFlashlight = cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(idForFlashlight, isChecked);
                } catch (CameraAccessException exception) {
                    System.out.println(exception);
                }
            }
        });
    }
}