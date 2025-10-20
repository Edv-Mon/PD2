package com.example.pd2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pd2.utils.TextCounter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils;

public class MainActivity extends AppCompatActivity {

    TextView tvCountResult;
    EditText edUserInput;
    Button button;
    Spinner spSelectionOp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.tvCountResult = findViewById(R.id.tvCountResult);
        this.edUserInput = findViewById(R.id.edUserInput);

        this.spSelectionOp = findViewById(R.id.spSelectionOp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOp.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        if(TextUtils.isEmpty(this.edUserInput.getText().toString())) {
            Toast.makeText(this, "The input is empty", Toast.LENGTH_SHORT).show();
        }
        else if(this.spSelectionOp.getSelectedItem().toString().equalsIgnoreCase("Number of characters")) {
            String userPhrase = this.edUserInput.getText().toString();
            int charsCount = TextCounter.getCharsCount(userPhrase);
            this.tvCountResult.setText(String.valueOf(charsCount));
        }
        else if(this.spSelectionOp.getSelectedItem().toString().equalsIgnoreCase("Number of words")) {
            String userPhrase = this.edUserInput.getText().toString();
            int wordsCount = TextCounter.getWordsCount(userPhrase);
            this.tvCountResult.setText(String.valueOf(wordsCount));
        }
        else if(this.spSelectionOp.getSelectedItem().toString().equalsIgnoreCase("Number of sentences")) {
            String userPhrase = this.edUserInput.getText().toString();
            int sentencesCount = TextCounter.getSentencesCount(userPhrase);
            this.tvCountResult.setText(String.valueOf(sentencesCount));
        }
        else{
            this.tvCountResult.setText("Invalid option");
        }

    }
}