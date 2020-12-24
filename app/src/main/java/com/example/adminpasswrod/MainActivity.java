package com.example.adminpasswrod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPasswordDialog();
            }
        });
    }

    private void openPasswordDialog() {
        PasswordView passwordView = new PasswordView(this);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(passwordView);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.show();
        passwordView.setOnSureListener(new PasswordView.OnSureListener() {
            @Override
            public void onclick(String word) {
                bottomSheetDialog.dismiss();
                if (TextUtils.isEmpty(word)) return;
                if (word.equals("123456")) {
                    Toast.makeText(MainActivity.this, String.format("正确：%s", word), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, String.format("错误：%s", word), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}