package com.emilg1101.app.closingcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.emilg1101.closingcard.ClosingCard;

public class MainActivity extends AppCompatActivity {

    ClosingCard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        card = (ClosingCard) findViewById(R.id.card);
        card = card.newBuilder()
                .setCornerRadius(35f)
                .setTitle("Personal information")
                .setButton("Next", new ClosingCard.OnButtonClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnCloseListener(new ClosingCard.OnCloseListener() {
                    @Override
                    public void onClose(View view) {
                        Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}
