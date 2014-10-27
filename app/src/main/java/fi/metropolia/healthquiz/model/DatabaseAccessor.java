package fi.metropolia.healthquiz.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dima on 10/9/2014.
 */
public class DatabaseAccessor extends SQLiteOpenHelper {

    public static final String QUESTION_GROUP = "QuestionGroup";
    private static final String QUESTION_GROUP_CREATION = "CREATE TABLE `" + QUESTION_GROUP + "` (" +
            "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`Name` TEXT NOT NULL" +
            ");";
    public static final String QUESTION = "Question";
    private static final String QUESTION_CREATION = "CREATE TABLE `" + QUESTION + "` (" +
            "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`QuestionGroupID` INTEGER NOT NULL," +
            "`HasPicture` INTEGER NOT NULL DEFAULT '0'," +
            "`Question` INTEGER NOT NULL" +
            "`Answered` INTEGER NOT NULL DEFAULT '0');";
    public static final String ANSWER = "Answer";
    private static final String ANSWER_CREATION = "CREATE TABLE `" + ANSWER + "` (" +
            "`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`QuestionID` INTEGER NOT NULL," +
            "`Answer` TEXT NOT NULL," +
            "`Correct` INTEGER NOT NULL DEFAULT '0'" +
            ");";
    private static final int DATABASE_VERSION = 8; //when adding stuff to the database, increment the version
    private static final String DATABASE_NAME = "HealthQuiz";


    public DatabaseAccessor(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUESTION_GROUP_CREATION);
        db.execSQL(QUESTION_CREATION);
        db.execSQL(ANSWER_CREATION);

        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(1,1,'Eroosiota',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(2,1,'Valkaisevat',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(3,1,'Ientulehdusta',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(4,1,'Abraasiota',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(5,2,'Ruokailun jälkeen',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(6,2,'Kerran päivässä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(7,2,'Ennen ruokailua',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(8,2,'Kerran viikossa',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(9,3,'Aiheuttavat päiväaikaista väsymystä',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(10,3,'Piristävät',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(11,3,'Pitävät minut terveenä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(12,4,'9-10h ',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(13,4,'7-8h',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(14,4,'11-12h',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(15,5,'tuulettamalla huone ja kuuntelemalla rauhallista musiikkia',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(16,5,'kovalla urheilutreenillä illalla klo 19.00',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(17,5,'nauttimalla Coca-Colaa ja tupakoimalla illalla',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(18,6,'10-15 %',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(19,6,'1%',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(20,6,'5%',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(21,6,'85%',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(22,7,'Masennus',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(23,7,'Syömishäiriö',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(24,7,'Psykoosi',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(25,7,'Peliriippuvuus',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(26,8,'Viiltelevä nuori tarvitsee viipymättä apua.',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(27,8,'Satunnainen viiltely on osa normaalia kehitystä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(28,8,'Viiltely on turvallista, kun sen tekee puhtailla välineillä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(29,8,'Viiltelystä tulee heti kertoa nuoren huoltajille, halusi nuori sitä tai ei.',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(30,9,'Aamupala',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(31,9,'Lounas',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(32,9,'Päivällinen',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(33,9,'Iltapala',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(34,10,'Kolme',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(35,10,'Neljä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(36,10,'Viisi',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(37,10,'Kuusi',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(38,11,'500 g',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(39,11,'1000 g',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(40,11,'100 g',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(41,11,'300 g',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(42,12,'Alkoholi',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(43,12,'Tupakka',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(44,12,'Liuotin kuten bensa',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(45,12,'Nuuska',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(46,13,'Vaikuttamalla muistiini ja oppimiseeni',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(47,13,'Sillä ei ole juurikaan vaikutusta',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(48,13,'Saan lisää ystäviä, minkä ansiosta viihdyn paremmin koulussa',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(49,13,'Helpottaa sitä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(50,14,'Kyllä voi',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(51,14,'Ei muutama kerta asiaan vaikuta',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(52,14,'Riippuu sukupuolesta',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(53,14,'Tupakka on päihde, joka ei aiheuta riippuvuutta',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(54,15,'Joka päivä',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(55,15,'3-5 kertaa viikossa',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(56,15,'1-2 kertaa viikossa',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(57,15,'en juuri koskaan',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(58,16,'Enintään 2 tuntia päivässä',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(59,16,'2-4 tuntia päivässä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(60,16,'yli 6 tuntia päivässä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(61,16,'4-6 tuntia päivässä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(62,17,'Liikun ulkona, esimerkiksi pelaan jalkapalloa kavereiden kanssa ',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(63,17,'Vietän aikaa ulkona',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(64,17,'Vietän aikaa sisällä',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(65,17,'Pelaan kännykällä tai tablettitietokoneella',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(66,18,'Erosion',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(67,18,'Whiten',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(68,18,'Gingivitis',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(69,18,'Abrasion',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(70,19,'After every meal',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(71,19,'Once a day',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(72,19,'Before a meal',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(73,19,'Once a week',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(74,20,'They cause daytime tiredness',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(75,20,'They make me feel more alert',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(76,20,'They keep me healthy',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(77,21,'9-10 hrs',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(78,21,'7-8 hrs',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(79,21,'11-12 hrs',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(80,22,'Opening the window to let the fresh air in and listening to calming music',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(81,22,'Heavy excercing at 7pm',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(82,22,'Having a can of Coca Cola and smoking before going to bed',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(83,23,'10-15 %',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(84,23,'1%',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(85,23,'5%',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(86,23,'85%',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(87,24,'Depression',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(88,24,'Eating disorder',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(89,24,'Psychosis',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(90,24,'Game addiction',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(91,25,'A self-harming young person needs immediate help.',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(92,25,'Casual self-harming is a normal part of growing up.',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(93,25,'Self-harming is safe, as long as the equipment is clean.',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(94,25,'You should tell about self-harming to young person''s parents straight away, whether they want it or now.',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(95,26,'Breakfast',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(96,26,'Lunch',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(97,26,'Dinner',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(98,26,'Evening snack',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(99,27,'Three times',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(100,27,'Four times',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(101,27,'Five times',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(102,27,'Six times',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(103,28,'500 g',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(104,28,'1000 g',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(105,28,'100 g',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(106,28,'300 g',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(107,29,'Alcohol',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(108,29,'Cigarettes',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(109,29,'Chemicals such as petrol',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(110,29,'Chewing tobacco',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(111,30,'If affects my memory and learning',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(112,30,'It doesn''t have much of an effect',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(113,30,'I get more friends which makes me want to go to school more',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(114,30,'It makes it easier',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(115,31,'That''s right.',1);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(116,31,'A couple of times won''t make a difference',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(117,31,'It depens on your sex',0);");
        db.execSQL("INSERT INTO `" + ANSWER + "` VALUES(118,31,'Cigarettes are a substance which doesn''t cause addiction',0);");
        
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(1,1,0,'Mitä limut ja energiajuomat aiheuttavat hampaille?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(2,1,0,'Milloin ksylitol-tuotteita tulisi käyttää?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(3,1,0,'Miten unihäiriöt vaikuttavat minun jokapäiväiseen elämääni? ');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(4,1,0,'Riittävä unen määrä minun ikäiselleni nuorelle on…');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(5,1,0,'Pystyn itse vaikuttamaan oman uneni laatuun ja päiväaikaiseen väsymykseen positiivisesti erityisesti seuraavin keinoin ');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(6,1,0,'Kuinka suuri osa suomalaisista nuorista tulee säännöllisesti kiusatuksi?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(7,1,0,'Mikä on nuorten yleisin mielenterveyden häiriö?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(8,1,0,'Miten viiltelyyn tulee suhtautua?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(9,1,0,'Mikä on päivän tärkein ateria?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(10,1,0,'Montako kertaa päivän aikana tulisi syödä?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(11,1,0,'Kuinka paljon päivässä tulisi syödä hedelmiä ja vihanneksia?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(12,1,0,'Mikä on yleisin nuorten käyttämä päihde?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(13,1,0,'Jos käytän alkoholia, miten se vaikuttaa minun koulunkäyntiini?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(14,1,0,'Olen kokeillut tupakkaa muutaman kerran. Nyt mietin voinko jäädä koukkuun tupakkaan?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(15,1,0,'Liikutko kouluikäisten fyysisen aktiivisuuden suositusten mukaisesti, vähintään 1–1½  tuntia päivässä?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(16,1,0,'Kuinka paljon vietät aikaa viihdemedian ääressä (mm. TV, tietokone, pelit, tabletit)?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(17,1,0,'Mitä teet useimmiten koulussa välitunnilla?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(18,2,0,'What do fizzy drinks and energy drinks cause to teeth?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(19,2,0,'When should you use xylitol products?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(20,2,0,'How do sleep problems affect my everyday life?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(21,2,0,'A sufficient amount of sleep for a young person my ages is…');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(22,2,0,'I can affect the quality of my sleep and daytime tiredness by doing the following...');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(23,2,0,'What percentage of young people is bullied at school regularly');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(24,2,0,'What is the most common mental health problem for young people?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(25,2,0,'How should I feel about self-harming?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(26,2,0,'What is the most important meal of the day?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(27,2,0,'How many times a day should you eat?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(28,2,0,'How much fruit and vegetables should you eat per day?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(29,2,0,'What is the most common substance used by young people?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(30,2,0,'If I use alcohol, what effect will it have on my school work?');");
        db.execSQL("INSERT INTO `" + QUESTION + "` VALUES(31,2,0,'I''ve tried smoking a couple of times. Now I''m worried I might become addicted.');");
        
        db.execSQL("INSERT INTO `" + QUESTION_GROUP + "` VALUES(1,'Suomi');");
        db.execSQL("INSERT INTO `" + QUESTION_GROUP + "` VALUES(2,'English');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("was called!!!");
        db.execSQL("DROP TABLE IF EXISTS QuestionGroup;");
        db.execSQL("DROP TABLE IF EXISTS Question;");
        db.execSQL("DROP TABLE IF EXISTS Answer;");
        onCreate(db);
    }

}
