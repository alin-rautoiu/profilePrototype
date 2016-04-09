package com.devacademy.profileprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    private static final String PROPERTY_NAME_EXTRA = "PROPERTY_NAME";

    //Asta ar trebui inlocuit cu ceva DataBaseManager
    private Datasource datasource = new Datasource();
    private Button editButton;
    private String propertyName;
    private MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        propertyName = intent.getStringExtra(PROPERTY_NAME_EXTRA);
        ((TextView)findViewById(R.id.edit_item_name)).setText(propertyName);


        editButton = (Button) findViewById(R.id.edit_submit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String propertyValue = ((EditText)findViewById(R.id.edit_item_value)).getText().toString();
                datasource.setValue(propertyName, propertyValue);
            }
        });

    }
}
