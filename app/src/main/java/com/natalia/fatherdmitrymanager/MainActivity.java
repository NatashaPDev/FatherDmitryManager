package com.natalia.fatherdmitrymanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.natalia.fatherdmitrymanager.data.QuestionsContracts;
import com.natalia.fatherdmitrymanager.data.QuestionsVariantsContracts;
import com.natalia.fatherdmitrymanager.data.VariantsAssociationsContracts;
import com.natalia.fatherdmitrymanager.data.VariantsContracts;
import com.natalia.fatherdmitrymanager.data.VariantsDbHelper;

public class MainActivity extends AppCompatActivity implements VariantListAdapter.OnItemClickListener{

    private static int sofaPoints = 50;
    private static int girlPoints = 50;
    private static int workPoints = 50;

    private SQLiteDatabase db;
    private VariantListAdapter variantListAdapter;

    private String currentQuestion = "question1";

    private boolean gameIsOver = false;

    private TextView tvQuestion;
    private ProgressBar pbSofa;
    private ProgressBar pbGirl;
    private ProgressBar pbWork;
    private RecyclerView variantList;
    private Button btnPlayNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Father Dmitry Manager");

        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        pbSofa = (ProgressBar) findViewById(R.id.pbSofa);
        pbGirl = (ProgressBar) findViewById(R.id.pbGirl);
        pbWork = (ProgressBar) findViewById(R.id.pbWork);
        btnPlayNew = (Button) findViewById(R.id.btnPlay);

        variantList = (RecyclerView) findViewById(R.id.rwVariantList);

        variantListAdapter = new VariantListAdapter(this);

        variantList.setLayoutManager(new LinearLayoutManager(this));
        variantList.setHasFixedSize(true);
        variantList.setAdapter(variantListAdapter);

        SQLiteOpenHelper dbHelper = new VariantsDbHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        refresh();
    }

    @Override
    public void OnItemClick(String variantId, View view) {

        Cursor cursor = db.query(VariantsAssociationsContracts.VariantsAssociatiosEntry.TABLE_VARIANTS,
                null,
                VariantsAssociationsContracts.VariantsAssociatiosEntry.COLUMN_VARIANT_FROM + "=?",
                new String[]{variantId},
                null,
                null,
                null);

        if (cursor.moveToNext()) {
            currentQuestion = cursor.getString(cursor.getColumnIndex(VariantsAssociationsContracts.VariantsAssociatiosEntry.COLUMN_VARIANT_TO));

        } else {
            gameIsOver = true;
        }

        cursor.close();

        cursor = db.query(VariantsContracts.VariantsEntry.TABLE_VARIANTS,
                null,
                VariantsContracts.VariantsEntry._ID + "=?",
                new String[]{variantId},
                null,
                null,
                null);

        if (cursor.moveToNext()) {

            sofaPoints += cursor.getInt(cursor.getColumnIndex(VariantsContracts.VariantsEntry.COLUMN_SOFA_POINTS));
            girlPoints += cursor.getInt(cursor.getColumnIndex(VariantsContracts.VariantsEntry.COLUMN_GIRL_POINTS));
            workPoints += cursor.getInt(cursor.getColumnIndex(VariantsContracts.VariantsEntry.COLUMN_WORK_POINTS));
        }

        if (sofaPoints < 0 || girlPoints < 0 || workPoints < 0) {
            gameIsOver = true;
        }

        cursor.close();

        refresh();
    }

    public void playNew(View view) {

        gameIsOver = false;

        variantList.setVisibility(View.VISIBLE);
        btnPlayNew.setVisibility(View.INVISIBLE);

        sofaPoints = 50;
        girlPoints = 50;
        workPoints = 50;

        currentQuestion = "question1";

        refresh();
    }

    private void refresh() {

        pbSofa.setProgress(sofaPoints);
        pbGirl.setProgress(girlPoints);
        pbWork.setProgress(workPoints);

        if (gameIsOver) {
            variantList.setVisibility(View.INVISIBLE);
            btnPlayNew.setVisibility(View.VISIBLE);

            if (sofaPoints >= 100 && girlPoints >= 100 && workPoints >= 100) {
                tvQuestion.setText("Готово! Ты великолепен!");
            } else {
                if (sofaPoints < 0) {
                    tvQuestion.setText("Это фиаско, братан!");

                } else if (girlPoints < 0) {
                    tvQuestion.setText("Твоя девушка бросила тебя:(");

                } else if (workPoints < 0) {
                    tvQuestion.setText("Вы банкрот, отец!");

                } else {
                    tvQuestion.setText("Хорошая попытка, но нет...");
                }
            }
            return;
        }


        Cursor cursor = db.query(QuestionsContracts.QuestionsEntry.TABLE_NAME,
                null,
                QuestionsContracts.QuestionsEntry._ID + "=?",
                new String[]{currentQuestion},
                null,
                null,
                null);

        if (cursor.moveToNext()) {
            tvQuestion.setText(cursor.getString(cursor.getColumnIndex(QuestionsContracts.QuestionsEntry.COLUMN_DESCRIPTION)));
        }

        cursor = db.query(QuestionsVariantsContracts.QuestionsVariantsEntry.TABLE_NAME,
                null,
                QuestionsVariantsContracts.QuestionsVariantsEntry.COLUMN_QUESTION + "=?",
                new String[]{currentQuestion},
                null,
                null,
                null);
        // TODO cursor.close()

        String ids = "";

        while (cursor.moveToNext()) {

            ids = ids + "'" + cursor.getString(cursor.getColumnIndex(QuestionsVariantsContracts.QuestionsVariantsEntry.COLUMN_VARIANT)) + "'";
            if (!cursor.isLast()) {
                ids = ids + ",";
            }

        }

        cursor.close();

        cursor = db.query(VariantsContracts.VariantsEntry.TABLE_VARIANTS,
                null,
                "_id in (" + ids + ")",
                null,
                null,
                null,
                null);

        variantListAdapter.setCursor(cursor);
    }
}
