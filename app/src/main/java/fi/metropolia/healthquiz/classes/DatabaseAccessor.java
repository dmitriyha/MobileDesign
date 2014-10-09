package fi.metropolia.healthquiz.classes;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Dima on 10/9/2014.
 */
public class DatabaseAccessor extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "HealthQuiz";
    public static final String QUESTION_GROUP = "QuestionGroup";
    public static final String QUESTION = "Question";
    public static final String ANSWER = "Answer";
    private static final String QUESTION_GROUP_CREATION = "CREATE TABLE `"+QUESTION_GROUP+"` (" +
            "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`Name` TEXT NOT NULL" +
            ");";
    private static final String QUESTION_CREATION = "CREATE TABLE `"+QUESTION+"` (" +
            "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`QuestionGroupID` INTEGER NOT NULL," +
            "`HasPicture` INTEGER NOT NULL DEFAULT '0'," +
            "`Question` INTEGER NOT NULL" +
            ");";
    private static final String ANSWER_CREATION = "CREATE TABLE `"+ANSWER+"` (" +
            "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`QuestionID` INTEGER NOT NULL," +
            "`Answer` TEXT NOT NULL," +
            "`Correct` INTEGER NOT NULL DEFAULT ''0''" +
            ");";


    public DatabaseAccessor(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(QUESTION_GROUP_CREATION);
        db.execSQL(QUESTION_CREATION);
        db.execSQL(ANSWER_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        System.out.println("was called!!!");
        db.execSQL("DROP TABLE IF EXISTS QuestionGroup;");
        db.execSQL("DROP TABLE IF EXISTS Question;");
        db.execSQL("DROP TABLE IF EXISTS Answer;");
        onCreate(db);
    }

}
