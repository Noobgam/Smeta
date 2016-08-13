package com.example.noobgam.button;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditNameActivity extends AppCompatActivity {

    public final static String APP = "com.example.noobgam.button.";
    private Button mButton;
    private EditText mText;
    private int BackRes;
    DBAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        adapter = new DBAdapter(this);
        adapter.open();

        mButton = (Button)findViewById(R.id.button);
        mText = (EditText) findViewById(R.id.ProjectName);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(EditNameActivity.this, EditRoomActivity.class);
                x.putExtra(APP + "name", mButton.getText());
                x.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(x, BackRes);
            }
        });

        mText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

//                if (charSequence.charAt(charSequence.length() - 1) == '\n') {
//                    System.out.println("ACTIVATED");
//                    mButton.performClick();
                //}
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void onDestroy()
    {
        adapter.close();
        super.onDestroy();
    }
}
