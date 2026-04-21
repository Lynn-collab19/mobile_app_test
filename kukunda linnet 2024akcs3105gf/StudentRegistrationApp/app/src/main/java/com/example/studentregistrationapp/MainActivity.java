package com.example.studentregistrationapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nameEditText, ageEditText, classEditText, contactEditText;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameEditText = findViewById(R.id.name);
        ageEditText = findViewById(R.id.age);
        classEditText = findViewById(R.id.classLevel);
        contactEditText = findViewById(R.id.contact);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(view -> {
            String name = (nameEditText.getText() != null) ? nameEditText.getText().toString().trim() : "";
            String age = (ageEditText.getText() != null) ? ageEditText.getText().toString().trim() : "";
            String classLevel = (classEditText.getText() != null) ? classEditText.getText().toString().trim() : "";
            String contact = (contactEditText.getText() != null) ? contactEditText.getText().toString().trim() : "";

            if (name.isEmpty() || age.isEmpty() || classLevel.isEmpty() || contact.isEmpty()) {
                Toast.makeText(MainActivity.this, getString(R.string.fill_all_fields), Toast.LENGTH_SHORT).show();
            } else {
                String successMessage = getString(R.string.registration_success, name);
                Toast.makeText(MainActivity.this, successMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
