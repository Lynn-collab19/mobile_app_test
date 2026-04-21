package com.example.systemcheckerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, ageEditText;
    CheckBox feverCheckBox, coughCheckBox, headacheCheckBox, stomachPainCheckBox;
    RadioGroup severityRadioGroup;
    TextView summaryTextView;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        nameEditText = findViewById(R.id.patientName);
        ageEditText = findViewById(R.id.patientAge);

        feverCheckBox = findViewById(R.id.fever);
        coughCheckBox = findViewById(R.id.cough);
        headacheCheckBox = findViewById(R.id.headache);
        stomachPainCheckBox = findViewById(R.id.stomachPain);

        severityRadioGroup = findViewById(R.id.severityGroup);
        summaryTextView = findViewById(R.id.result);
        submitButton = findViewById(R.id.submitBtn);

        submitButton.setOnClickListener(view -> {
            String name = nameEditText.getText().toString().trim();
            String age = ageEditText.getText().toString().trim();

            // Basic validation
            if (name.isEmpty() || age.isEmpty()) {
                Toast.makeText(MainActivity.this, getString(R.string.validation_error), Toast.LENGTH_SHORT).show();
                return;
            }

            // Collect selected symptoms
            StringBuilder symptoms = new StringBuilder();
            if (feverCheckBox.isChecked()) symptoms.append(getString(R.string.symptom_fever)).append(", ");
            if (coughCheckBox.isChecked()) symptoms.append(getString(R.string.symptom_cough)).append(", ");
            if (headacheCheckBox.isChecked()) symptoms.append(getString(R.string.symptom_headache)).append(", ");
            if (stomachPainCheckBox.isChecked()) symptoms.append(getString(R.string.symptom_stomach_pain)).append(", ");

            String selectedSymptoms = symptoms.toString();
            if (selectedSymptoms.endsWith(", ")) {
                selectedSymptoms = selectedSymptoms.substring(0, selectedSymptoms.length() - 2);
            } else if (selectedSymptoms.isEmpty()) {
                selectedSymptoms = "None selected";
            }

            // Get selected severity
            int selectedId = severityRadioGroup.getCheckedRadioButtonId();
            String severity = "Not selected";
            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                severity = selectedRadioButton.getText().toString();
            }

            // Display summary and success message
            String summary = getString(R.string.summary_header) + "\n" +
                    "Name: " + name + "\n" +
                    "Age: " + age + "\n" +
                    "Symptoms: " + selectedSymptoms + "\n" +
                    "Severity: " + severity + "\n\n" +
                    "Status: Symptoms submitted successfully!";

            summaryTextView.setText(summary);
            
            // Show a Toast for confirmation
            Toast.makeText(MainActivity.this, "Symptoms submitted successfully!", Toast.LENGTH_LONG).show();
        });
    }
}
