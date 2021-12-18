package tdtu.lab03_exam01;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//518H0043-Trần Hồng Nhung
public class MainActivity extends AppCompatActivity {
    Button buttonLogin;
    EditText editTextEmail;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin =findViewById(R.id.buttonLogin);
        editTextEmail =findViewById(R.id.editTextEmail);
        textView=findViewById(R.id.textView);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openSomeActivityForResult();

            }
        });


    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity2.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        String name = data.getStringExtra("result");

                        textView.setText("Hẹn gặp lại");
                        editTextEmail.setText(name);
                        buttonLogin.setVisibility(View.INVISIBLE);


                    }
                }
            });

    public void openSomeActivityForResult() {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        String email = editTextEmail.getText().toString();
        intent.putExtra("email",email);
        someActivityResultLauncher.launch(intent);

    }


}
