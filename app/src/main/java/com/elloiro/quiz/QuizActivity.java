package com.elloiro.quiz;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elloiro.quiz.PreguntaTest;

public class QuizActivity extends AppCompatActivity {

    private PreguntaTest pregunta;
    private RadioGroup respostesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Generate_question();

        TextView textView = findViewById(R.id.Text_View);
        respostesView = findViewById(R.id.Respostes_view);
        RadioButton button_resposta_1 = findViewById(R.id.Button_resposta_1);
        RadioButton button_resposta_2 = findViewById(R.id.Button_resposta_2);
        RadioButton button_resposta_3 = findViewById(R.id.Button_resposta_3);
        RadioButton button_resposta_4 = findViewById(R.id.Button_resposta_4);

        textView.setText(pregunta.getText());
        button_resposta_1.setText(pregunta.getRespostes()[0]);
        button_resposta_2.setText(pregunta.getRespostes()[1]);
        button_resposta_3.setText(pregunta.getRespostes()[2]);
        button_resposta_4.setText(pregunta.getRespostes()[3]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu:
                    comprova_resposta();
                break;

            case R.id.reset:
                 respostesView.clearCheck();
                break;
        }
        return true;
    }

    private void comprova_resposta()
    {
        int index = getbuttonIndex();
        if (index == pregunta.getCorrect())
        {
            Toast.makeText(this,"Molt Bé!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Torna a Provar!",Toast.LENGTH_LONG).show();
        }
    }

    private int getbuttonIndex() {
        int selected = respostesView.getCheckedRadioButtonId();
        int ids[] = {R.id.Button_resposta_1,R.id.Button_resposta_2,R.id.Button_resposta_3,R.id.Button_resposta_4};
        int index = -1;
        for (int i = 0; i< ids.length;i++)
        {
            if (ids[i]== selected)
            {
                index = i;
                break;
            }
        }
        return index;
    }

    private void Generate_question() {
        String[] respostes = getStrings();

        pregunta = new PreguntaTest( "Capital de Vietnam?", respostes,  3);
    }

    @NonNull
    private String[] getStrings() {
        String[] respostes = new String[4];
        respostes[0] = "BCN";
        respostes[1] = "Paris";
        respostes[2] = "Londres";
        respostes[3] = "Hanoi";
        return respostes;
    }
}
