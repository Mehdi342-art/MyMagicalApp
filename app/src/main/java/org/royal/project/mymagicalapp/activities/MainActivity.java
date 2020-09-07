package org.royal.project.mymagicalapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.royal.project.mymagicalapp.R;
import org.royal.project.mymagicalapp.models.UserAccount;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private Button save;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        database = FirebaseDatabase.getInstance();
//        databaseReference = database.getReference();

        initViews();
        addListenerToSaveButton();



    }

    private void addListenerToSaveButton() {

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSaveData();
            }
        });
    }

    private void validateAndSaveData() {

        //validate entered data
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();

        if (!TextUtils.isEmpty(usernameValue)){

            if(!TextUtils.isEmpty(passwordValue)){

                UserAccount userAccount = new UserAccount(usernameValue,passwordValue);

//                databaseReference.setValue(userAccount).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
//                    }
//                });

            }else {
                Toast.makeText(MainActivity.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(MainActivity.this, "Please enter valid username", Toast.LENGTH_SHORT).show();
        }
        //save them inside database
    }



    private void initViews() {

        username = (EditText)findViewById(R.id.et_username);
        password = (EditText)findViewById(R.id.et_password);
        save = (Button)findViewById(R.id.btn_save);

    }
}