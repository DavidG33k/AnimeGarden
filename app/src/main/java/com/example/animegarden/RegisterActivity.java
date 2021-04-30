package com.example.animegarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText username;
    private EditText email;
    private EditText password;
    private ProgressBar progressBar;
    private Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        register_button = (Button) findViewById(R.id.register_button);
        register_button.setOnClickListener(this);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                register_user();
                break;
        }
    }

    private void register_user() {
        String username_string = username.getText().toString().trim();
        String email_string = email.getText().toString().trim();
        String password_string = password.getText().toString().trim();

        if(username_string.isEmpty()){
            email.setError("Inserisci username");
            email.requestFocus();
            return;
        }

        if(email_string.isEmpty()){
            email.setError("Inserisci l'email!");
            email.requestFocus();
            return;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email_string).matches()) {
            email.setError("Inserisci un indirizzo valido!");
            email.requestFocus();
            return;
        }

        if(password_string.isEmpty()){
            password.setError("Inserisci la password!");
            email.requestFocus();
            return;
        }
        else if(password_string.length() < 8) {
            password.setError("La passsword deve avere almeno 8 caratteri!");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email_string, password_string).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    HashMap<String, String> user = new HashMap<String, String>();

                    user.put("username", username_string);

                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                    // Add a new document with a generated ID
                    db.collection("Users").document(mAuth.getCurrentUser().getUid()).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Registrazione completata.", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }
                            else {
                                Toast.makeText(RegisterActivity.this, "Registrazione fallita! Riprova!", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Registrazione fallita! Riprova!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}