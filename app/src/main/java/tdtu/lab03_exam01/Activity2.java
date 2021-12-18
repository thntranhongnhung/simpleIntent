package tdtu.lab03_exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//518H0043-Trần Hồng Nhung
public class Activity2 extends AppCompatActivity {
    TextView textViewWelcome;
    Button buttonSaveExit;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");


        textViewWelcome  =findViewById(R.id.textViewWelcome);
        buttonSaveExit =findViewById(R.id.buttonSaveExit);
        editTextName =findViewById(R.id.editTextName);

        String hello ="Xin chào,";
        String given =" vui lòng nhập tên";
        textViewWelcome.setText(hello+" "+ email+given);
        buttonSaveExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                replyIntent.putExtra("result",editTextName.getText().toString());
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }

}