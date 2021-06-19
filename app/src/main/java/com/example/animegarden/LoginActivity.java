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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private EditText email, password;
    private Button login_button;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseUser user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        register = (TextView)findViewById(R.id.register_button);
        register.setOnClickListener(this);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        login_button = (Button)findViewById(R.id.login_button);
        login_button.setOnClickListener(this);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        //LOGIN SESSION CHECK
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
            Toast.makeText(getApplicationContext(), "Hai eseguito l'accesso con " + user.getEmail(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_button:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case R.id.login_button:
                login_user();
        }
    }

    private void login_user() {
        String email_string = email.getText().toString().trim();
        String password_string = password.getText().toString().trim();

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
            password.requestFocus();
            return;
        }
        else if(password_string.length() < 8) {
            password.setError("La passsword deve avere almeno 8 caratteri!");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email_string, password_string).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
                }
                else{
                    Toast.makeText(LoginActivity.this, "Credenziali errate.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}