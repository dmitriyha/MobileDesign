package fi.metropolia.healthquiz.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Dima on 10/9/2014.
 */
public class DatabaseAccessor extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4; //when adding stuff to the database, increment the version
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
            "`Correct` INTEGER NOT NULL DEFAULT '0'" +
            ");";


    public DatabaseAccessor(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(QUESTION_GROUP_CREATION);
        db.execSQL(QUESTION_CREATION);
        db.execSQL(ANSWER_CREATION);
        db.execSQL("INSERT INTO `"+QUESTION_GROUP+"`(`ID`,`Name`) VALUES (1,'Placeholder1');");
        db.execSQL("INSERT INTO `"+QUESTION_GROUP+"`(`ID`,`Name`) VALUES (2,'Placeholder2');");
        db.execSQL("INSERT INTO `"+QUESTION+"`(`ID`,`QuestionGroupID`,`HasPicture`,`Question`) VALUES (1,1,0,'Is this question is interesting?');");
        db.execSQL("INSERT INTO `"+QUESTION+"`(`ID`,`QuestionGroupID`,`HasPicture`,`Question`) VALUES (2,1,0,'Is this question is not interesting?');");
        db.execSQL("INSERT INTO `"+QUESTION+"`(`ID`,`QuestionGroupID`,`HasPicture`,`Question`) VALUES (3,2,0,'This is not the question you are looking for!');");
        db.execSQL("INSERT INTO `"+ANSWER+"`(`ID`,`QuestionID`,`Answer`,`Correct`) VALUES (1,1,'yes',1);");
        db.execSQL("INSERT INTO `"+ANSWER+"`(`ID`,`QuestionID`,`Answer`,`Correct`) VALUES (2,1,'no',0);");
        db.execSQL("INSERT INTO `"+ANSWER+"`(`ID`,`QuestionID`,`Answer`,`Correct`) VALUES (3,2,'no',1);");
        db.execSQL("INSERT INTO `"+ANSWER+"`(`ID`,`QuestionID`,`Answer`,`Correct`) VALUES (4,2,'yes',0);");
        db.execSQL("INSERT INTO `"+ANSWER+"`(`ID`,`QuestionID`,`Answer`,`Correct`) VALUES (5,3,'Hang on, this IS the question Im looking for!!!',0);");
        db.execSQL("INSERT INTO `"+ANSWER+"`(`ID`,`QuestionID`,`Answer`,`Correct`) VALUES (6,3,'Carry on',1);");
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
